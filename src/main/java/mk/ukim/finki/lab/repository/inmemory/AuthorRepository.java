package mk.ukim.finki.lab.repository.inmemory;

import jakarta.annotation.Nullable;
import jakarta.annotation.PostConstruct;
import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class AuthorRepository {
    private List<Author> authorList = null;

    @PostConstruct
    public void init()
    {
        authorList = new ArrayList<>();
        authorList.add(new Author(1L, "J.K.", "Rowling", "Best-selling author of the Harry Potter series."));
        authorList.add(new Author(2L, "George", "Orwell", "Known for classics like 1984 and Animal Farm."));
        authorList.add(new Author(3L, "Agatha", "Christie", "Famous for her detective novels, including Hercules Poirot and Miss Marple series."));
        authorList.add(new Author(4L, "Harper", "Lee", "Author of To Kill a Mockingbird."));
        authorList.add(new Author(5L, "William", "Shakespeare", "Renowned playwright and poet of the Elizabethan era."));
    }

    public List<Author> findAll(){
        return this.authorList;
    }
    public Author findById(Long id)  {
        if(authorList.stream().filter(a -> a.getId().equals(id)).findFirst().isPresent()){
            Author ath = authorList.stream().filter(a->a.getId().equals(id)).findFirst().orElse(null);
            return ath;
        }
        return null;
    }
}
