package com.ibm.company.mq;

import org.springframework.stereotype.Component;

@Component
public interface RabbitMqListner {

	public void processMessage(CommandModel model);
}
