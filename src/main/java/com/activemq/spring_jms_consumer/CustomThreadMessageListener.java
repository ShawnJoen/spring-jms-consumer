package com.activemq.spring_jms_consumer;

import javax.jms.*;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class CustomThreadMessageListener implements MessageListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomThreadMessageListener.class);

	public void onMessage(Message message) {
		
		try {
			ActiveMQTextMessage msg = (ActiveMQTextMessage) message;
	        final String jsonString = msg.getText();

	        JSON jsonData = (JSON)JSONObject.parse(jsonString);
	        TestVO testVO = JSONObject.toJavaObject(jsonData, TestVO.class);
            if (testVO == null) {
                return;
            }
            
	        System.out.println(testVO.getName());
	        
        } catch (JMSException e) {
            e.printStackTrace();
        }
	}
}