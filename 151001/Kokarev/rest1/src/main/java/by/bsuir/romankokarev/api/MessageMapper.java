package by.bsuir.romankokarev.api;

import by.bsuir.romankokarev.impl.bean.Message;
import by.bsuir.romankokarev.impl.dto.MessageRequestTo;
import by.bsuir.romankokarev.impl.dto.MessageResponseTo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MessageMapper {
    MessageMapper INSTANCE = Mappers.getMapper( MessageMapper.class );
    Message MessageResponseToToMessage(MessageResponseTo messageResponseTo);
    Message MessageRequestToToMessage(MessageRequestTo messageRequestTo);
    MessageResponseTo MessageToMessageResponseTo(Message message);
    MessageRequestTo MessageToMessageRequestTo(Message message);
}
