package org.ignou.lltp;


import java.util.ArrayList;
import java.util.List;

import org.ignou.lltp.entities.Project;
import org.ignou.lltp.entities.User;
import org.ignou.lltp.repository.ProjectRepository;
import org.ignou.lltp.repository.UserRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
public class CustomerMaster {
	public static void main(String[] args) {
		

	AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				BeanConfiguration.class);
	ProjectRepository repository = context
				.getBean(ProjectRepository.class);
	
	UserRepository usrRepository = context
			.getBean(UserRepository.class);
	
		
		User usr = usrRepository.findOne(1L);
		Project prj = repository.findOne(1L);
		
		//usr.addProject(prj);
		usrRepository.save(usr);
		
		
		((AbstractApplicationContext) context).close();
	}
		/*ChapterRepository repository = context
				.getBean(ChapterRepository.class);*/
		
		/*QuestionRepository qrepository = context
				.getBean(QuestionRepository.class);
		
		DiagnsoticClassDataCreator dCreator = new DiagnsoticClassDataCreator();
		
		dCreator.getDiagnosticData();
		List<String> classes = qrepository.findAvailableClasses();
		System.out.println(classes);*/
		
		
		//String substitution
/*		String question = "What is another word for anticipate?";
		int length = question.length();
		int x = 25;
		int y = 35;
		String quesText = question.substring(0, x)+"!"+question.substring(x, length);
		String nextques = quesText.substring(0, y+1)+"~"+quesText.substring(y+1, quesText.length());
		String finalStr = nextques.replaceAll("!", "[b]");
		finalStr = finalStr.replaceAll("~", "[/b]");*/
		
/*	List<DataChapter> chapList = repository.findChaptersForClass();	
 * 
 * for (DataChapter dataChapter : chapList) {
			System.out.println(dataChapter.getChapterName());
			for (DataTopic dataTopic : dataChapter.getTopics()) {
				System.out.println(dataTopic.getTopicName());
				for (DataPassage dataPassage : dataTopic.getPassages()) {
					System.out.println(dataPassage.getPassageText());
					System.out.println("-------------------------"+"  "+dataPassage.getPassageNumber());
					for (DataQuestion dataQuestion : dataPassage.getQuestions()) {
						System.out.println(dataQuestion.getQuestionText());
						for (DataAnswer dataAnswer : dataQuestion.getAnswers()) {
							System.out.println(dataAnswer.getAnswer()+"  "+dataAnswer.getAnswerType());
						}
					}
				}
			}
		}*/
	
}