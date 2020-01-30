package ua.com.university;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import ua.com.university.dao.DepartmentDao;
import ua.com.university.dao.DepartmentLectorDao;
import ua.com.university.dao.LectorDao;
import ua.com.university.dao.RankDao;
import ua.com.university.db.DatabaseFilling;
import ua.com.university.entity.Department;
import ua.com.university.entity.DepartmentLector;
import ua.com.university.entity.Lector;
import ua.com.university.entity.Rank;
import ua.com.university.service.DepartmentLectorService;
import ua.com.university.service.DepartmentService;
import ua.com.university.service.impl.DepartmentLectorServiceImpl;
import ua.com.university.service.impl.DepartmentServiceImpl;
import ua.com.university.view.UniversityConsoleView;

import java.util.Scanner;

@SpringBootApplication
@EntityScan(basePackages = "ua.com.university.entity")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(final LectorDao lectorDao, final DepartmentDao departmentDao, final RankDao rankDao, final DepartmentLectorDao departmentLectorDao, final DepartmentService departmentService, final DepartmentLectorService departmentLectorService) throws Exception {
		return (String[] args) -> {
			DatabaseFilling databaseFilling = new DatabaseFilling();
			databaseFilling.fillDb(lectorDao,departmentDao,rankDao,departmentLectorDao);
//			DepartmentLectorService departmentLectorService = new DepartmentLectorServiceImpl();
//			DepartmentService departmentService = new DepartmentServiceImpl();
			UniversityConsoleView universityConsoleView = new UniversityConsoleView(departmentService,departmentLectorService);
			lectorDao.findAll().forEach(lector -> System.out.println(lector));

			Scanner sc =new Scanner(System.in);
			while (true){
				universityConsoleView.firstWatch();
				int number = sc.nextInt();
				switch (number){
					case 1:{
						universityConsoleView.showHeadOfDepartment(sc);
						break;
					}
					case 2:{
						universityConsoleView.ShowDepartmentStatistic(sc);
						break;
					}
					case 3:{
						universityConsoleView.showAverageSalaryForDepartment(sc);
						break;
					}
					case 4:{
						universityConsoleView.showCountOfEmployeeForDepartment(sc);
						break;
					}
                    case 5:{
                        universityConsoleView.showSearchForLectors(sc);
                        break;
                    }
                    default:{
                        throw new IllegalArgumentException("Wrong number");
                    }

				}
				System.out.print("And one more time ");
			}
		};
	}
}