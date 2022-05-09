package recipe.com.example.food.advice;

import java.util.NoSuchElementException;

import javax.persistence.EntityExistsException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import recipe.com.example.food.Exceptions.ElementExistsException;
import recipe.com.example.food.Exceptions.NoSuchElementFoundException;
import recipe.com.example.food.Exceptions.UserNotFoundException;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(NoSuchElementFoundException.class)
	public ResponseEntity<String>
					handleEmptyResponse(NoSuchElementFoundException userNotFoundException){
						return new ResponseEntity<String>("no element is present in database with given name or Id", HttpStatus.NOT_FOUND);
						
		
	}
	
	@ExceptionHandler(ElementExistsException.class)
	public ResponseEntity<String>
	handleEmptyResponse(EntityExistsException ElementAlreadyExists){
		return new ResponseEntity<String>("Element with given id / name already exists in db", HttpStatus.BAD_REQUEST);
		
	}
}
