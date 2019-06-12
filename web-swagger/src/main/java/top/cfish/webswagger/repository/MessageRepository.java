package top.cfish.webswagger.repository;


import top.cfish.webswagger.entity.Message;

import java.util.List;

/**
 * @author: isisiwish
 * @date: 2019/5/23
 * @time: 14:55
 */
public interface MessageRepository
{
    List<Message> findAll();
    
    Message save(Message message);
    
    Message update(Message message);
    
    Message updateText(Message message);
    
    Message findMessage(Long id);
    
    void deleteMessage(Long id);
}
