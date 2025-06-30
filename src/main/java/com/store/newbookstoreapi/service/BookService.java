@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepo;
    private final ISBNGenerator isbnGenerator;

    public BookDTO createBook(BookDTO dto) {
        String isbn;
        do {
            isbn = isbnGenerator.generateISBN();
        } while (bookRepo.existsByIsbn(isbn));

        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(isbn);

        return toDTO(bookRepo.save(book));
    }

    public BookDTO getBook(Long id) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        return toDTO(book);
    }

    public List<BookDTO> getAllBooks() {
        return bookRepo.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public BookDTO updateBook(Long id, BookDTO dto) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());

        return toDTO(bookRepo.save(book));
    }

    public void deleteBook(Long id) {
        if (!bookRepo.existsById(id)) {
            throw new ResourceNotFoundException("Book not found");
        }
        bookRepo.deleteById(id);
    }

    private BookDTO toDTO(Book book) {
        return new BookDTO(book.getId(), book.getTitle(), book.getAuthor());
    }
}
