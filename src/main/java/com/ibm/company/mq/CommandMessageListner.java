package com.ibm.company.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.company.entities.Company_Emp_Commands;
import com.ibm.company.repository.ICompanyCommandRepository;

@Component
public class CommandMessageListner implements RabbitMqListner {

	@Autowired
	ICompanyCommandRepository commandRepo;

	 @RabbitListener(queues =RabbitConfig.commandQueue)
	public void processMessage(CommandModel model) {
		 Company_Emp_Commands commands = new Company_Emp_Commands();
		 commands.setName(model.getCommandName());
		 commands.setStatus(model.getStatus());
		 commands.setCommanddesc(model.getCommandDesc());
		 commandRepo.save(commands);
		System.out.println(model.getCommandDesc());

	}

}
