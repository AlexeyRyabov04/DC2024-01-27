package by.bsuir.publicator.service.editor.impl;

import by.bsuir.publicator.bean.Editor;
import by.bsuir.publicator.dto.EditorRequestTo;
import by.bsuir.publicator.dto.EditorResponseTo;
import by.bsuir.publicator.exception.DuplicateEntityException;
import by.bsuir.publicator.exception.EntityNotFoundException;
import by.bsuir.publicator.repository.editor.EditorRepository;
import by.bsuir.publicator.service.editor.IEditorService;
import by.bsuir.publicator.util.converter.editor.EditorConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class EditorService implements IEditorService {
    private final EditorRepository editorRepository;
    private final EditorConverter editorConverter;
    private final String ENTITY_NAME = "editor";

    @Autowired
    public EditorService(EditorRepository editorRepository, EditorConverter editorConverter) {
        this.editorRepository = editorRepository;
        this.editorConverter = editorConverter;
    }

    @Override
    public List<EditorResponseTo> getEditors() {
        List<Editor> editors = editorRepository.findAll();
        return editors.stream().map(editorConverter::convertToResponse).toList();
    }

    @Override
    public EditorResponseTo getEditorById(BigInteger id) throws EntityNotFoundException {
        Optional<Editor> editor = editorRepository.findById(id);
        if (editor.isEmpty()) {
            throw new EntityNotFoundException(ENTITY_NAME, id);
        }
        return editorConverter.convertToResponse(editor.get());
    }

    @Override
    public EditorResponseTo createEditor(EditorRequestTo editor) throws DuplicateEntityException {
        try {
            Editor savedEditor = editorRepository.save(editorConverter.convertToEntity(editor));
            return editorConverter.convertToResponse(savedEditor);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEntityException(ENTITY_NAME, "login");
        }
    }

    @Override
    public EditorResponseTo updateEditor(EditorRequestTo editor) throws EntityNotFoundException {
        if (editorRepository.findById(editor.getId()).isEmpty()) {
            throw new EntityNotFoundException(ENTITY_NAME, editor.getId());
        }
        Editor savedEditor = editorRepository.save(editorConverter.convertToEntity(editor));
        return editorConverter.convertToResponse(savedEditor);
    }

    @Override
    public void deleteEditor(BigInteger id) throws EntityNotFoundException {
        if (editorRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException(ENTITY_NAME, id);
        }
        editorRepository.deleteById(id);
    }
}
