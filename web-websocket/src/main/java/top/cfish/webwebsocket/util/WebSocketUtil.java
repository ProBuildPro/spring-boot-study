package top.cfish.webwebsocket.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: isisiwish
 * @date: 2019/5/23
 * @time: 18:44
 */
@Slf4j
public class WebSocketUtil
{
	// 存储 websocket session
	public static final Map<String, Session> ONLINE_USER_SESSIONS = new ConcurrentHashMap<>();
	
	public static void sendMessage(Session session, String message)
	{
		if (session == null)
		{
			return;
		}
		final RemoteEndpoint.Basic basic = session.getBasicRemote();
		if (basic == null)
		{
			return;
		}
		try
		{
			basic.sendText(message);
		}
		catch (IOException e)
		{
			log.error("sendMessage Exception", e);
		}
	}
	
	public static void sendMessageAll(String message)
	{
		ONLINE_USER_SESSIONS.forEach((sessionId, session)->sendMessage(session, message));
	}
}
