package by.bsuir.publicator.controller;

import by.bsuir.publicator.dto.CommentRequestTo;
import by.bsuir.publicator.dto.CommentResponseTo;
import by.bsuir.publicator.exception.DuplicateEntityException;
import by.bsuir.publicator.exception.EntititesNotFoundException;
import by.bsuir.publicator.exception.EntityNotFoundException;
import by.bsuir.publicator.service.comment.ICommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CommentControllerTest {

    @Mock
    private ICommentService commentService;

    @InjectMocks
    private CommentController commentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetComments() throws EntititesNotFoundException {
        List<CommentResponseTo> comments = new ArrayList<>();
        when(commentService.getComments()).thenReturn(comments);

        List<CommentResponseTo> result = commentController.getComments();

        assertEquals(comments, result);
        verify(commentService, times(1)).getComments();
    }

    @Test
    void testGetCommentById() throws EntityNotFoundException {
        BigInteger commentId = BigInteger.valueOf(1);
        CommentResponseTo comment = new CommentResponseTo();
        when(commentService.getCommentById(commentId)).thenReturn(comment);

        CommentResponseTo result = commentController.getCommentById(commentId);

        assertEquals(comment, result);
        verify(commentService, times(1)).getCommentById(commentId);
    }

    @Test
    void testAddComment() throws DuplicateEntityException, EntityNotFoundException {
        CommentRequestTo commentRequest = new CommentRequestTo();

        commentController.addComment(commentRequest);

        verify(commentService, times(1)).addComment(commentRequest);
    }

    @Test
    void testUpdateComment() throws EntityNotFoundException, DuplicateEntityException {
        CommentRequestTo updatedComment = new CommentRequestTo();

        commentController.updateComment(updatedComment);

        verify(commentService, times(1)).updateComment(updatedComment);
    }

    @Test
    void testDeleteComment() throws EntityNotFoundException {
        BigInteger commentId = BigInteger.valueOf(1);

        commentController.deleteComment(commentId);

        verify(commentService, times(1)).deleteComment(commentId);
    }
}
