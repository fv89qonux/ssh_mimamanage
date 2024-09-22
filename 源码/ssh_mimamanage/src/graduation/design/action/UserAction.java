package graduation.design.action;

import graduation.design.dao.ObjectManager;
import graduation.design.model.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import system.common.util.PageModel;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("unchecked")
public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String errMsg;
	private String field;
	private String fieldValue;

	private ObjectManager objectManager;

	private PageModel<User> pageModel;

	private User util;

	public String deleteUtil() throws Exception {
		objectManager.deleteObject(util);
		util = null;
		return getAllUtil();
	}
	
	public String deleteManyUtil() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids[] = request.getParameterValues("id");
		User util = null;
		for (String id : ids) {
			util = new User();
			util.setId(Integer.parseInt(id));
			objectManager.deleteObject(util);
		}
		util = null;
		return getAllUtil();
	}

	public String getAllUtil() throws Exception {
		if (null == pageModel) {
			pageModel = new PageModel<User>();
		}
		if (0 == pageModel.getCurrentPageNo()) {
			pageModel.setCurrentPageNo(1);
		}
		StringBuilder _sql = new StringBuilder();
		_sql.append(" from User ");
		if (null != field && field.trim().length() > 0) {
			fieldValue = new String(fieldValue.getBytes("UTF-8"), "UTF-8");
			_sql.append(" where " + field + " like '%" + fieldValue + "%'");
		}
		pageModel = objectManager.getUtil(_sql.toString(), pageModel.getCurrentPageNo());
		errMsg = null;
		return "find";
	}
	
	@SuppressWarnings("rawtypes")
	public String saveOrUpdateObject() throws Exception {
		if (null != util && 0 == util.getId()) {
			if(null == util.getS_0() || "".equals(util.getS_0())){
				errMsg = "用户名不能为空";
				return "saveOrUpdate";
			}
			String sql = "from User where s_0 = '" + util.getS_0() + "'";
			List list = objectManager.getUtil(sql);
			if (null != list && list.size() > 0) {
				errMsg = "该用户名已被使用";
				return "saveOrUpdate";
			}
		}
		objectManager.saveOrUpdateObject(util);
		util = null;
		errMsg = null;
		return getAllUtil();
	}

	public String selectUtil() throws Exception {
		util = (User) objectManager.getObject(new User(), util.getId());
		errMsg = null;
		return "saveOrUpdate";
	}
	


	public String getErrMsg() {
		return errMsg;
	}

	public String getField() {
		return field;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public ObjectManager getObjectManager() {
		return objectManager;
	}

	public PageModel<User> getPageModel() {
		return pageModel;
	}

	public User getUtil() {
		return util;
	}
	
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	public void setField(String field) {
		this.field = field;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public void setObjectManager(ObjectManager objectManager) {
		this.objectManager = objectManager;
	}

	public void setPageModel(PageModel<User> pageModel) {
		this.pageModel = pageModel;
	}

	public void setUtil(User util) {
		this.util = util;
	}

}
