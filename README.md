Erstell immer eine README.md für das lokale Setup
Kurze generelle Tipps. Die Reihenfolge ist immer die:
- Model -> definiert dein Object
- DTO (Data Transfer Object) -> zum Rumschubsen zwischen Client und Server (brauchst du hier nicht)
- Service -> Business Logik
- Controller -> Server -> Client (API)
- DB
- Repositories -> der Layer der die DB Operationen ausführt

FIXME:
- Benenn mal bitte die Klassen um von DataStorage = Models und generelle Models bitte ohne Data
- Weiß nicht was diese Datastorage Objekte sind aber selbst wenn du sie jetzt benutzt hat nichts mit der Praxis zu tun

SignIn Template Line 42
        <form th:action="@{/signIn}" th:object="${user}" method="post" class="d-flex col-10">
                <p class="label-radionbox col-6 px-2">Wählen Sie eine Rolle*:</p>
                <div class="form-check px-2">
                    <input type="radio" class="form-check-input" th:field="*{role}" id="buyer" value="Käufer" name="role" required>
                    <label for="buyer" class="form-check-label">Käufer</label>
                </div>
Und dann immer so weiter mit den th:field für die anderen Parameter von UserData.

UserData fehlt die @Entity Annotation für Spring
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;
    private String vorname;
    private String nachname;
    private String email;
    private String password;

    // Getters and setters
}

Zum Speichern in der DB erstelle ein Repository das extended ein Interface das eigentlich schon Operationen wie save beinhaltet

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

Dann das erstelle Repository autowiren in den Controller und die Methode aufrufen

@Controller
public class SignInController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signIn")
    public String saveUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/success";  // Redirect to a success page or the desired page
    }

Application Properties erweitern mit JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

PS: Howard ist ein Noob
