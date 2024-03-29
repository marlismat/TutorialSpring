package com.digitel.consultasp.service;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.digitel.consultasp.model.Ciudades;
import com.digitel.consultasp.model.Estado;
import com.digitel.consultasp.model.Estados;
import com.digitel.consultasp.model.IMSI;
import com.digitel.consultasp.model.IMSIS;
import com.digitel.consultasp.model.Municipio;
import com.digitel.consultasp.model.Municipios;
import com.digitel.consultasp.model.SuperInfo;
import com.digitel.consultasp.model.UserTypes;
import com.digitel.servicios.adaptador.JdbcCRMDao;
import com.digitel.servicios.adaptador.JdbcConfigDao;
import com.digitel.servicios.adaptador.JdbcPNNDao;

import oracle.net.aso.u;




public class ConsultaService {
	public static  IMSIS FindImsi(String idIMSI){
		IMSIS imsis = new IMSIS();
		try {
			//Llamaar al pool de conexion
			JdbcTemplate jdbcTemplate =  JdbcPNNDao.getJdbcTemplate();
			
			
			// Senstivo
			jdbcTemplate.setResultsMapCaseInsensitive(true);
						
			SimpleJdbcCall validaImsi;	
						
//						funcion para invocar el SP
			validaImsi = new SimpleJdbcCall(jdbcTemplate.getDataSource()). withSchemaName("pnnprod").
								withProcedureName("SP_SEARCH_ICCID")
								.returningResultSet("cv_results", BeanPropertyRowMapper.newInstance(IMSI.class));		
			
			SqlParameterSource in = new MapSqlParameterSource()
			.addValue("p_iccid", idIMSI);
			

	Map<String, Object> resultMap = validaImsi.execute(in);	

	System.out.println(resultMap); 
						
	resultMap.get("cv_results");
	List <IMSI> list = (List<IMSI>) resultMap.get("cv_results");
	imsis.setIMSIS(list);
	imsis.setCodigo((String) resultMap.get("p_code"));
	imsis.setExecution_code((String) resultMap.get("p_execution_code"));
	imsis.setMensaje((String) resultMap.get("p_execution_message"));
	//new UserTypes(resultMap.get("P_USER_TYPE"), resultMap.get("p_cod_result"), resultMap.get("p_cod_error"));
		
		
		}catch (Exception e) {
			e.printStackTrace();
			
			System.out.println(e);
			System.out.println(e.getStackTrace().toString());
		}
		
		
		return imsis;
		
	}
	
	public static  SuperInfo ConsultaSuper(String idProduct,String vip) {
		UserTypes uT = new UserTypes();
		Ciudades ciudades = new Ciudades();
		SuperInfo superInfo = new SuperInfo();
		try {
			uT = ConsultaService.ConsultaType(idProduct,vip);
			ciudades = FindCiudad();
			superInfo.setCiudades(ciudades);
			superInfo.setUserType(uT);
		
		
		
		}catch (Exception e) {
			e.printStackTrace();
			
			System.out.println(e);
			System.out.println(e.getStackTrace().toString());
		}
		
		return superInfo;
		
	}
	
public static  UserTypes ConsultaType(String idProduct,String vip) {
	UserTypes uT = new UserTypes();
	
	
	try {
		
		//Llamaar al pool de conexion
		
		JdbcTemplate jdbcTemplate =  JdbcConfigDao.getJdbcTemplate();
		
		
		// Senstivo
		jdbcTemplate.setResultsMapCaseInsensitive(true);
					
					//
		SimpleJdbcCall UserType;	
					
//					funcion para invocar el SP
		UserType = new SimpleJdbcCall(jdbcTemplate.getDataSource()).withCatalogName("PKG_USER_CONFIG").
							withProcedureName("SP_GET_USER_TYPE");		
		
		SqlParameterSource in = new MapSqlParameterSource()
		.addValue("P_COS_NAME", idProduct)
		.addValue("P_CHANNEL", "ASWEB" )
		.addValue("P_VIP_CODE", vip );
		

Map<String, Object> resultMap = UserType.execute(in);	

System.out.println(resultMap); 
					
resultMap.get("P_USER_TYPE");

uT.setUserType((String) resultMap.get("P_USER_TYPE"));
uT.setCode((String) resultMap.get("P_COD_ERROR"));
uT.setResult((String) resultMap.get("P_COD_RESULT"));
//new UserTypes(resultMap.get("P_USER_TYPE"), resultMap.get("p_cod_result"), resultMap.get("p_cod_error"));
	}catch (Exception e) {
		// TODO: handle exception
		
		e.printStackTrace();
		
		System.out.println(e);
		System.out.println(e.getStackTrace().toString());
	
	
	}
		
	return uT;
	}
	public static Estados FindMult(
			) {
		List<Estado> ObjectList = null;
		Estados obj = new Estados();		
//		String p_execution_code = "";
//		String p_execution_message = "";
		try {
			
			//Llamaar al pool de conexion
			
			JdbcTemplate jdbcTemplate =  JdbcCRMDao.getJdbcTemplate();
			
			// Senstivio
			jdbcTemplate.setResultsMapCaseInsensitive(true);
			
			//
			SimpleJdbcCall ProcListMarca;	
			
//			funcion para invocar el SP
			ProcListMarca = new SimpleJdbcCall(jdbcTemplate.getDataSource()). withSchemaName("BDUC").
					withProcedureName("SP_SEARCH_ESTADO")					
					.returningResultSet("cv_results", BeanPropertyRowMapper.newInstance(Estado.class));		// se coloca solo si retorna un objeto  
			;
			
			
			/*SqlParameterSource in = new MapSqlParameterSource()
					.addValue("cv_results", Types.REF_CURSOR)
					.addValue("p_execution_code", p_execution_code )
					.addValue("p_execution_message", p_execution_message )
					
				;*/
			
			Map<String, Object> resultMap = ProcListMarca.execute();	
			
			System.out.println(resultMap); 
			
		
			ObjectList = (List<Estado>) resultMap.get("cv_results"); // se coloca el nombre de la variable de acuerdo al que tenga el SP
				
			String valor = (String) resultMap.get("p_execution_code");
			System.out.println(valor);
			
								
			
			obj.setEstado(ObjectList);
			
		}catch (Exception e) {
			// TODO: handle exception
			ObjectList = null;
			obj = null;
			e.printStackTrace();
			
			System.out.println(e);
			System.out.println(e.getStackTrace().toString());
		
		
		}
		return obj;
	}

	
	public static Municipios FindMunicipio () {
		List<Municipio> ObjectList = null;
		Municipios obj = new Municipios();		
		try {
			
			JdbcTemplate jdbcTemplate =  JdbcCRMDao.getJdbcTemplate();
			
			// Senstivio
			jdbcTemplate.setResultsMapCaseInsensitive(true);
			
			//
			SimpleJdbcCall ProcListMarca;				
			ProcListMarca = new SimpleJdbcCall(jdbcTemplate.getDataSource()). withSchemaName("BDUC").
					withProcedureName("SP_SEARCH_MUNICIPIOCIUDAD")					
					.returningResultSet("cv_results", BeanPropertyRowMapper.newInstance(Municipio.class));		 
			;
			
			Map<String, Object> resultMap = ProcListMarca.execute();	
			
			System.out.println(resultMap); 
		
			ObjectList = (List<Municipio>) resultMap.get("cv_results");
			obj.setMunicipios(ObjectList);
		}catch (Exception e) {
			// TODO: handle exception
			ObjectList = null;
			obj = null;
			e.printStackTrace();
		
		}
		
		return obj;
	}
	
	
	
	public static Ciudades FindCiudad () {
		List<Ciudades> ObjectList = null; 
		Ciudades obj = new Ciudades();		
		try {
			
			JdbcTemplate jdbcTemplate =  JdbcCRMDao.getJdbcTemplate();
			
			// Senstivio
			jdbcTemplate.setResultsMapCaseInsensitive(true);
			
			//
			SimpleJdbcCall ProcListMarca;				
			ProcListMarca = new SimpleJdbcCall(jdbcTemplate.getDataSource()). withSchemaName("BDUC").
					withProcedureName("SP_SEARCH_CIUDAD_ESTADO")					
					.returningResultSet("cv_results", BeanPropertyRowMapper.newInstance(Municipio.class));		 
			;
			
			Map<String, Object> resultMap = ProcListMarca.execute();	
			
			System.out.println(resultMap); 
		
			ObjectList = (List<Ciudades>) resultMap.get("cv_results");
			obj.setCiudades(ObjectList);
		}catch (Exception e) {
			// TODO: handle exception
			ObjectList = null;
			obj = null;
			e.printStackTrace();
		
		}
		
		return obj;
	}
	
	
	
	public static Ciudades FindIccid () {
		List<Ciudades> ObjectList = null; 
		Ciudades obj = new Ciudades();		
		try {
			
			JdbcTemplate jdbcTemplate =  JdbcCRMDao.getJdbcTemplate();
			
			// Senstivio
			jdbcTemplate.setResultsMapCaseInsensitive(true);
			
			//
			SimpleJdbcCall ProcListMarca;				
			ProcListMarca = new SimpleJdbcCall(jdbcTemplate.getDataSource()). withSchemaName("BDUC").
					withProcedureName("SP_SEARCH_CIUDAD_ESTADO")					
					.returningResultSet("cv_results", BeanPropertyRowMapper.newInstance(Municipio.class));		 
			;
			
			Map<String, Object> resultMap = ProcListMarca.execute();	
			
			System.out.println(resultMap); 
		
			ObjectList = (List<Ciudades>) resultMap.get("cv_results");
			obj.setCiudades(ObjectList);
		}catch (Exception e) {
			// TODO: handle exception
			ObjectList = null;
			obj = null;
			e.printStackTrace();
		
		}
		
		return obj;
	}
}

