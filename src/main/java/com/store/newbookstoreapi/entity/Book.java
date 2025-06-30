

@Entity
@Table(name = "books", uniqueConstraints = {@UniqueConstraint(columnNames = {"isbn"})})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String title;

    @NotBlank
    @Size(max = 50)
    private String author;

    @Column(unique = true, nullable = false, length = 13)
    private String isbn;
}
