package by.bsuir.poit.dc.rest.services;

import by.bsuir.poit.dc.rest.api.dto.request.UpdateNewsDto;
import by.bsuir.poit.dc.rest.api.dto.request.UpdateNewsLabelDto;
import by.bsuir.poit.dc.rest.api.dto.request.UpdateNoteDto;
import by.bsuir.poit.dc.rest.api.dto.response.PresenceDto;
import by.bsuir.poit.dc.rest.api.dto.response.LabelDto;
import by.bsuir.poit.dc.rest.api.dto.response.NewsDto;
import by.bsuir.poit.dc.rest.api.dto.response.NoteDto;
import jakarta.validation.Valid;

import java.util.List;

/**
 * @author Paval Shlyk
 * @since 31/01/2024
 */
public interface NewsService {
    NewsDto create(@Valid UpdateNewsDto dto);

    NewsDto update(long newsId, @Valid UpdateNewsDto dto);

    NewsDto getById(long newsId);

    List<NewsDto> getByOffsetAndLimit(long offset, int limit);

    @Deprecated
    List<NewsDto> getAll();

    PresenceDto existsById(long newsId);

    PresenceDto delete(long newsId);

    @Deprecated(forRemoval = true)
    NoteDto createNote(long newsId, @Valid UpdateNoteDto dto);

    void attachLabelById(long newsId, @Valid UpdateNewsLabelDto dto);

    PresenceDto detachLabelById(long newsId, long labelId);

    List<NewsDto> getNewsByUserId(long userId);

    List<NewsDto> getNewsByLabel(String label);

    List<NoteDto> getNotesByNewsId(long newsId);

    List<LabelDto> getLabelsByNewsId(long newsId);
}
