package graduation.design.action;

import java.util.*;
import graduation.design.model.*;
import graduation.design.dao.ObjectManager;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.*;

import system.common.util.PageModel;

@SuppressWarnings({ "unchecked", "serial" })
public class MimamanageAction extends ActionSupport {
	private Mimamanage util;
	private PageModel<Mimamanage> pageModel;
	private List<User> listUser;
	private String errMsg;
	private String field;
	private String fieldValue;
	private ObjectManager objectManager;

	public String initUtil() throws Exception{
		listUser = objectManager.getUtil("from User");
		util = null;
		return "saveOrUpdate";
	}

	@SuppressWarnings("rawtypes")	
	public String saveOrUpdateObject() throws Exception{
		if (null != util && 0 == util.getId()) {                           
			if(null == util.getS_0() || "".equals(util.getS_0())){         
				errMsg = "名称不能为空";                          
				return "saveOrUpdate";                                       
			}                                                                
			String sql = "from Mimamanage where s_0 = '" + util.getS_0() + "'";
			List list = objectManager.getUtil(sql);                          
			if (null != list && list.size() > 0) {                           
				errMsg = "该名称已存在";                                   
				return "saveOrUpdate";                                       
			}                                                                
		}              
		String base64 = Base64.getEncoder().encodeToString(util.getS_2().getBytes("UTF-8"));
		util.setS_2(base64);
		objectManager.saveOrUpdateObject(util);
		util = null;
		errMsg = null;
		return getAllUtil();
	}

	public String deleteUtil() throws Exception{
		objectManager.deleteObject(util);
		util = null;
		errMsg = null;
		return getAllUtil();
	}

	public String deleteManyUtil() throws Exception {                
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids[] = request.getParameterValues("id");             
		Mimamanage util = null;                                              
		for (String id : ids) {                                        
			util = new Mimamanage();                                           
			util.setId(Integer.parseInt(id));                            
			objectManager.deleteObject(util);                            
		}                                                              
		util = null;                                                   
		return getAllUtil();                                           
	}                                                                
	public String selectUtil() throws Exception{
		listUser = objectManager.getUtil("from User");
		util = (Mimamanage) objectManager.getObject(new Mimamanage(), util.getId());
		byte[] bytes = Base64.getDecoder().decode(util.getS_2());
		util.setS_2(new String(bytes, "UTF-8"));
		return "saveOrUpdate";
	}

	public String getAllUtil() throws Exception{
		Map<?, ?> session = ActionContext.getContext().getSession();
		String type = (String) session.get("type");
		//int id = (Integer) session.get("id");
		if (null == pageModel) {
			pageModel = new PageModel<Mimamanage>();
		}
		if (0 == pageModel.getCurrentPageNo()) {
			pageModel.setCurrentPageNo(1);
		}
		StringBuilder _sql = new StringBuilder();
		_sql.append(" from Mimamanage where 1 = 1 ");
		if (!"admin".equals(type)) {
			//_sql.append(" and user.id = " + id);
		}
		if("s_2".equals(field)) {
			String base64 = Base64.getEncoder().encodeToString(fieldValue.getBytes("UTF-8"));
			fieldValue = base64;
		}
		if (null != field && field.trim().length() > 0) {
			fieldValue = new String(fieldValue.getBytes("UTF-8"), "UTF-8");
			_sql.append(" and " + field + " like '%" + fieldValue + "%'");
		}
		pageModel = objectManager.getUtil(_sql.toString(), pageModel.getCurrentPageNo());
		List<Mimamanage> mimamanages = pageModel.getList();
		for(Mimamanage mimamanage:mimamanages) {
			byte[] bytes = Base64.getDecoder().decode(mimamanage.getS_2());
			mimamanage.setS_2(new String(bytes, "UTF-8"));
		}
		errMsg = null;
		return "find";
	}

	public Mimamanage getUtil() {
		return util;
	}

	public void setUtil(Mimamanage util) {
		this.util = util;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public ObjectManager getObjectManager() {
		return objectManager;
	}

	public void setObjectManager(ObjectManager objectManager) {
		this.objectManager = objectManager;
	}

	public PageModel<Mimamanage> getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel<Mimamanage> pageModel) {
		this.pageModel = pageModel;
	}

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

}
