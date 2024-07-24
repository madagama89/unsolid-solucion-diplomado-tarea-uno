import com.example.demo.EmployeeRepositoryImpl;
import com.example.demo.FileStorageServiceImpl;
import com.example.demo.PartTimeEmployee;
import com.example.demo.ReportGenerator;
import com.example.demo.SalaryCalculator;
import com.example.demo.SalaryServiceImpl;
import com.example.demo.interfaces.EmployeeRepository;
import com.example.demo.interfaces.FileStorageService;
import com.example.demo.interfaces.SalaryService;

import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {


        Random random = new Random();
        EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
        SalaryService salaryService = new SalaryServiceImpl(employeeRepository);
        FileStorageService fileStorageService = new FileStorageServiceImpl();
        ReportGenerator reportGenerator = new ReportGenerator();
        SalaryCalculator salaryCalculator = new SalaryCalculator(salaryService);

        employeeRepository.addEmployee("Marlon David Garcia", "Engineering");
        employeeRepository.addEmployee("Claudia Alexandra Bojaca", "Marketing");
        employeeRepository.addEmployee("Javier Mahecha", "Marketing");

        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Karen", "Finance", 20, 1000.0 + (4000.0 * random.nextDouble()));
        System.out.println("Nombre del empleado a tiempo parcial: " + partTimeEmployee.getName());
        System.out.println("Departamento: " + partTimeEmployee.getDepartment());
        System.out.println("Salario a tiempo parcial: " + partTimeEmployee.calculatePartTimeSalary());

        // Calcular salario
        double salary = salaryCalculator.calculateSalary("Marlon David Garcia1");
        System.out.println("Salario de Marlon David Garcia: " + salary);

        // Generar reportes
        reportGenerator.generateReportExcel(((EmployeeRepositoryImpl) employeeRepository).getEmployees());
        reportGenerator.generateReportPDF(((EmployeeRepositoryImpl) employeeRepository).getEmployees());

        // Guardar empleado en archivo
        fileStorageService.saveToFile("Marlon David Garcia");
       
    }
}
