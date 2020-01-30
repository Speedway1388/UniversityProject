package ua.com.university.view;

import ua.com.university.entity.Lector;
import ua.com.university.service.DepartmentLectorService;
import ua.com.university.service.DepartmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class UniversityConsoleView {


    DepartmentService departmentService;

    DepartmentLectorService departmentLectorService;

    public UniversityConsoleView() {
    }

    public UniversityConsoleView(DepartmentService departmentService, DepartmentLectorService departmentLectorService) {
        this.departmentService = departmentService;
        this.departmentLectorService = departmentLectorService;
    }

    public void firstWatch() throws InterruptedException {
        System.out.println("welcome to our university");
        Thread.sleep(1000);
        System.out.println("what do you want?");
        Thread.sleep(1000);
        System.out.println("1.Who is head of department {department_name}\n" +
                "2.Show {department_name} statistic.\n" +
                "3. Show the average salary for department {department_name}.\n" +
                "4. Show count of employee for {department_name}.\n" +
                "5. Global search by {template}.   \n");
    }
    public void showHeadOfDepartment(Scanner sc){
        String departmentName = chooseDepartment(sc);
        Lector headOfDepartment = departmentService.getHeadOfDepartment(departmentName);
        System.out.println("Head of" + departmentName + "is " + headOfDepartment);
    }
    public void ShowDepartmentStatistic(Scanner sc){
        String name = chooseDepartment(sc);
        Map<String, Integer> rankCountByDepartment = departmentLectorService.getRankCountByDepartment(departmentService.getDepartmentIdByName(name));
        System.out.println("Assistants - " + rankCountByDepartment.get("assistant"));
        System.out.println("Associate professors - " + rankCountByDepartment.get("associate professor"));
        System.out.println("Professors - " + rankCountByDepartment.get("professor"));
    }
    public void showAverageSalaryForDepartment(Scanner sc){
        String departmentName = chooseDepartment(sc);
        Long averageSalary = departmentLectorService.getAverageSalaryForDepartment(departmentService.getDepartmentIdByName(departmentName));
        System.out.println("The average salary of" + departmentName + "is " +  averageSalary);
    }
    public void showCountOfEmployeeForDepartment(Scanner sc){
        String name = chooseDepartment(sc);
        System.out.println(departmentLectorService.getCountOfEmployeeForDepartment(name));
    }
    public void showSearchForLectors(Scanner sc){
        System.out.println("Enter the keyword");
        String keyWord = sc.next();
        List<Lector> lectors = new ArrayList<>(departmentLectorService.findByKeyWord(keyWord));
        for (Lector lector: lectors
             ) {
            System.out.println(lector.getName() + " " + lector.getSurName());
        }
    }
    private void showAllDepartments(){

        departmentService.getAllDepartments().forEach(department -> System.out.print(department.getName() + ", "));
    }
    private String  chooseDepartment(Scanner sc){
        System.out.print("here we have that departments:");
        showAllDepartments();
        System.out.println("please enter department name");
        return sc.next();
    }


}
