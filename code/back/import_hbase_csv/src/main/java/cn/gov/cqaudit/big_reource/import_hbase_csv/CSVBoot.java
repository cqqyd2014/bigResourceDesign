package cn.gov.cqaudit.big_reource.import_hbase_csv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cn.gov.cqaudit.big_resource.import_hbase_module.impl.CSVImporter;

@SpringBootApplication(scanBasePackages = { "cn.gov.cqaudit.**" })
public class CSVBoot implements CommandLineRunner {

	@Autowired
	CSVImporter cSVImporter;

	public static void main(String[] args) {
		SpringApplication.run(CSVBoot.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/**
		 * 一共有
		 * 
		 */
		if (args.length != 3) {
			System.out.println("需要3个参数");
		}

		try {
			cSVImporter.setBatchCount(Integer.parseInt(args[0]));
			cSVImporter.setTemplateFileName(args[1]);
			cSVImporter.setDataFileName(args[2]);
			cSVImporter.init();
			cSVImporter.do_import_hbase_batch(cSVImporter.getList());
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		

	}
}