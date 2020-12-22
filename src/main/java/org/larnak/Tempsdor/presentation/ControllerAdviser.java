package org.larnak.Tempsdor.presentation;

import org.larnak.Tempsdor.exception.*;
import org.larnak.Tempsdor.exception.report.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(assignableTypes = {ActivityController.class,
                                    BookingController.class,
                                    RoomController.class,
                                    UserController.class})
public class ControllerAdviser extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ActivityAlreadyExistException.class)
    public ResponseEntity<ActivityAlreadyExistReport> ActivityAlreadyExistExceptionHandler(ActivityAlreadyExistException ex, HttpServletRequest request){

        ActivityAlreadyExistReport report = new ActivityAlreadyExistReport(ex.getIndex(), request.getMethod(), request.getRequestURI());

        return ResponseEntity.badRequest().body(report);
    }

    @ExceptionHandler(ActivityNotFoundException.class)
    public ResponseEntity<ActivityNotFoundReport> ActivityNotFoundExceptionHandler(ActivityNotFoundException ex, HttpServletRequest request){

        ActivityNotFoundReport report = new ActivityNotFoundReport(ex.getIndex(), request.getMethod(), request.getRequestURI());

        return ResponseEntity.badRequest().body(report);
    }

    @ExceptionHandler(BookingAlreadyExistException.class)
    public ResponseEntity<BookingAlreadyExistReport> BookingAlreadyExistExceptionHandler(BookingAlreadyExistException ex, HttpServletRequest request){

        BookingAlreadyExistReport report = new BookingAlreadyExistReport(ex.getIndex(), request.getMethod(), request.getRequestURI());

        return ResponseEntity.badRequest().body(report);
    }


    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<BookingNotFoundReport> ActivityNotFoundExceptionHandler(BookingNotFoundException ex, HttpServletRequest request){

        BookingNotFoundReport report = new BookingNotFoundReport(ex.getIndex(), request.getMethod(), request.getRequestURI());

        return ResponseEntity.badRequest().body(report);
    }

    @ExceptionHandler(RoomAlreadyExistException.class)
    public ResponseEntity<RoomAlreadyExistReport> RoomlreadyExistExceptionHandler(RoomAlreadyExistException ex, HttpServletRequest request){

        RoomAlreadyExistReport report = new RoomAlreadyExistReport(ex.getIndex(), request.getMethod(), request.getRequestURI());

        return ResponseEntity.badRequest().body(report);
    }

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<RoomNotFoundReport> RoomNotFoundExceptionHandler(RoomNotFoundException ex, HttpServletRequest request){

        RoomNotFoundReport report = new RoomNotFoundReport(ex.getIndex(), request.getMethod(), request.getRequestURI());

        return ResponseEntity.badRequest().body(report);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<UserAlreadyExistReport> UserAlreadyExistExceptionHandler(UserAlreadyExistException ex, HttpServletRequest request){

        UserAlreadyExistReport report = new UserAlreadyExistReport(ex.getIndex(), request.getMethod(), request.getRequestURI());

        return ResponseEntity.badRequest().body(report);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<UserNotFoundReport> UserNotFoundExceptionHandler(UserNotFoundException ex, HttpServletRequest request){

        UserNotFoundReport report = new UserNotFoundReport(ex.getIndex(), request.getMethod(), request.getRequestURI());

        return ResponseEntity.badRequest().body(report);
    }

}
