import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Employee saveEmployee(Employee employee) {
        // Encrypt password
        String encryptedPassword = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encryptedPassword);
        return employeeRepository.save(employee);
    }
}