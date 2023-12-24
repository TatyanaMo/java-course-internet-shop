package com.app.services;

import com.app.dao.AuthorDAO;
import com.app.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServices {
   @Autowired
   private AuthorDAO authorDAO;

   public void storeNewAuthor(Author author) {
       //Field data validation here
       authorDAO.storeNewAuthor(author);
   }
}
