package system.common.util;

import graduation.design.dao.ObjectManager;
import graduation.design.dao.ObjectManagerImpl;
import graduation.design.model.User;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

 
public class ExportDB {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();

		SchemaExport export = new SchemaExport(cfg);

		export.create(true, true);
		ObjectManager objectManager = new ObjectManagerImpl();
		User util = new User();
		util.setS_0("admin");
		util.setS_1("admin");
		util.setS_2("admin");
		util.setS_11("admin");
		objectManager.saveObject(util);

	}
}
