package com.example.demo;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SurveyController {
	 private SurveyRepository surveyRepository = new SurveyRepository();

	 
	 public SurveyController(SurveyRepository surveyRepository) {
	        this.surveyRepository = surveyRepository;
	    }
	 public SurveyController() {
	        // Encuesta 1: Tecnología
	        Survey survey1 = new Survey(1L, "Encuesta sobre tecnología");
	        Question question1 = new Question(1L, "¿Cuál es tu lenguaje de programación favorito?");
	        question1.addOption(new Option(1L, "Java"));
	        question1.addOption(new Option(2L, "Python"));
	        question1.addOption(new Option(3L, "PHP"));
	        survey1.addQuestion(question1);
	        surveyRepository.addSurvey(survey1);

	        // Encuesta 2: Deportes
	        Survey survey2 = new Survey(2L, "Encuesta sobre deportes");
	        Question question2 = new Question(2L, "¿Cuál es tu deporte favorito?");
	        question2.addOption(new Option(1L, "Fútbol"));
	        question2.addOption(new Option(2L, "Baloncesto"));
	        question2.addOption(new Option(3L, "Tenis"));
	        survey2.addQuestion(question2);
	        surveyRepository.addSurvey(survey2);

	        // Encuesta 3: Cine
	        Survey survey3 = new Survey(3L, "Encuesta sobre cine");
	        Question question3 = new Question(3L, "¿Cuál es tu género de cine favorito?");
	        question3.addOption(new Option(1L, "Acción"));
	        question3.addOption(new Option(2L, "Comedia"));
	        question3.addOption(new Option(3L, "Terror"));
	        question3.addOption(new Option(4L, "Drama"));
	        survey3.addQuestion(question3);
	        surveyRepository.addSurvey(survey3);

	        // Encuesta 4: Hábitos alimenticios
	        Survey survey4 = new Survey(4L, "Encuesta sobre hábitos alimenticios");
	        Question question4 = new Question(4L, "¿Qué prefieres comer?");
	        question4.addOption(new Option(1L, "Comida rápida"));
	        question4.addOption(new Option(2L, "Comida casera"));
	        question4.addOption(new Option(3L, "Vegetariana"));
	        question4.addOption(new Option(4L, "Vegana"));
	        survey4.addQuestion(question4);
	        surveyRepository.addSurvey(survey4);

	        // Encuesta 5: Música
	        Survey survey5 = new Survey(5L, "Encuesta sobre música");
	        Question question5 = new Question(5L, "¿Qué género musical prefieres?");
	        question5.addOption(new Option(1L, "Pop"));
	        question5.addOption(new Option(2L, "Rock"));
	        question5.addOption(new Option(3L, "Clásica"));
	        question5.addOption(new Option(4L, "Jazz"));
	        survey5.addQuestion(question5);
	        surveyRepository.addSurvey(survey5);

	        // Encuesta 6: Viajes
	        Survey survey6 = new Survey(6L, "Encuesta sobre viajes");
	        Question question6 = new Question(6L, "¿Cuál es tu destino favorito?");
	        question6.addOption(new Option(1L, "Playa"));
	        question6.addOption(new Option(2L, "Montañas"));
	        question6.addOption(new Option(3L, "Ciudades históricas"));
	        question6.addOption(new Option(4L, "Parques naturales"));
	        survey6.addQuestion(question6);
	        surveyRepository.addSurvey(survey6);

	        // Encuesta 7: Videojuegos
	        Survey survey7 = new Survey(7L, "Encuesta sobre videojuegos");
	        Question question7 = new Question(7L, "¿Cuál es tu plataforma de videojuegos favorita?");
	        question7.addOption(new Option(1L, "PC"));
	        question7.addOption(new Option(2L, "Consolas"));
	        question7.addOption(new Option(3L, "Móviles"));
	        survey7.addQuestion(question7);
	        surveyRepository.addSurvey(survey7);

	        // Encuesta 8: Educación
	        Survey survey8 = new Survey(8L, "Encuesta sobre educación");
	        Question question8 = new Question(8L, "¿Cuál es tu método de aprendizaje favorito?");
	        question8.addOption(new Option(1L, "Aprender por mi cuenta"));
	        question8.addOption(new Option(2L, "Clases presenciales"));
	        question8.addOption(new Option(3L, "Clases en línea"));
	        survey8.addQuestion(question8);
	        surveyRepository.addSurvey(survey8);

	        // Encuesta 9: Medio ambiente
	        Survey survey9 = new Survey(9L, "Encuesta sobre medio ambiente");
	        Question question9 = new Question(9L, "¿Qué acciones realizas para cuidar el medio ambiente?");
	        question9.addOption(new Option(1L, "Reciclaje"));
	        question9.addOption(new Option(2L, "Ahorro de energía"));
	        question9.addOption(new Option(3L, "Uso de transporte público"));
	        question9.addOption(new Option(4L, "Compostaje"));
	        survey9.addQuestion(question9);
	        surveyRepository.addSurvey(survey9);

	        // Encuesta 10: Redes sociales
	        Survey survey10 = new Survey(10L, "Encuesta sobre redes sociales");
	        Question question10 = new Question(10L, "¿Cuánto tiempo pasas al día en redes sociales?");
	        question10.addOption(new Option(1L, "Menos de 1 hora"));
	        question10.addOption(new Option(2L, "1-2 horas"));
	        question10.addOption(new Option(3L, "2-4 horas"));
	        question10.addOption(new Option(4L, "Más de 4 horas"));
	        survey10.addQuestion(question10);
	        surveyRepository.addSurvey(survey10);
	    }

	    

	    @GetMapping("/survey/{id}")
	    public String showSurvey(@PathVariable Long id, Model model) {
	        Survey survey = surveyRepository.getSurveyById(id).orElseThrow();
	        model.addAttribute("survey", survey);
	        return "survey-detail";
	    }

	    @PostMapping("/submitVote")
	    public String submitVoteForm(@RequestParam String vote, Model model) {
	        model.addAttribute("result", vote);
	        return "resultado";
	    }
	    
	    @GetMapping("/surveys")
	    public String listSurveys(Model model) {
	        List<Survey> surveys = surveyRepository.getAllSurveys();
	        model.addAttribute("surveys", surveys);  // Aquí pasas la lista de encuestas
	        return "survey-list";  // La vista correspondiente
	    }

	    @GetMapping("/surveys/{id}")
	    public String surveyDetail(@PathVariable Long id, Model model) {
	        Optional<Survey> survey = surveyRepository.getSurveyById(id);
	        if (survey.isPresent()) {
	            model.addAttribute("survey", survey.get());  // Aquí pasas una encuesta específica
	            return "survey-detail";  // Vista para ver el detalle de la encuesta
	        }
	        return "error";  // En caso de que no se encuentre la encuesta
	    }
	    
	    

	    @PostMapping("/submitVote/{id}")
	    public String submitVote(@PathVariable Long id, @RequestParam("voteId") Long voteId, Model model) {
	        Survey survey = surveyRepository.getSurveyById(id).orElseThrow();
	        for (Question question : survey.getQuestions()) {
	            for (Option option : question.getOptions()) {
	                if (option.getId().equals(voteId)) {
	                    option.incrementVotes();
	                }
	            }
	        }
	        model.addAttribute("survey", survey);  // Pasa la encuesta con los resultados actualizados
	        return "resultado"; // Actualiza la vista con los resultados
	    }
	    
	    @GetMapping("/survey")
	    public String showSurvey(Model model) {
	        // Agregar datos del formulario a la vista, si es necesario
	        return "survey-form";
	    }
	    
	    @GetMapping("/resultado")
	    public String resultado(Model model) {
	        model.addAttribute("result", "Opción elegida"); // Cambia esto con tu lógica real
	        return "resultado";
	    }
}
