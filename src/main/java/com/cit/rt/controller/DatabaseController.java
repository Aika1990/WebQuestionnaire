package com.cit.rt.controller;

import com.cit.rt.entity.Answer;
import com.cit.rt.entity.District;
import com.cit.rt.entity.Question;
import com.cit.rt.entity.Settlement;
import com.cit.rt.exception.ResourceNotFoundException;
import com.cit.rt.service.AnswerService;
import com.cit.rt.service.DistrictService;
import com.cit.rt.service.QuestionService;
import com.cit.rt.service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/database")
public class DatabaseController {
    @Autowired
    private SettlementService settlementService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @GetMapping("/save")
    public String setDatabase(Model model) throws ResourceNotFoundException {

        districtService.saveDistrict(new District("Бай-Тайгинский"));
        districtService.saveDistrict(new District("Баруун-Хемчикский"));
        districtService.saveDistrict(new District("Дзун-Хемчикский"));
        districtService.saveDistrict(new District("Каа-Хемский"));
        districtService.saveDistrict(new District("Кызылский кожуун"));
        districtService.saveDistrict(new District("Монгун-Тайгинский"));
        districtService.saveDistrict(new District("Овюрский"));
        districtService.saveDistrict(new District("Пий-Хемский"));
        districtService.saveDistrict(new District("Сут-Хольский"));
        districtService.saveDistrict(new District("Тандинский"));
        districtService.saveDistrict(new District("Тере-Хольский"));
        districtService.saveDistrict(new District("Тес-Хемский"));
        districtService.saveDistrict(new District("Тоджинский"));
        districtService.saveDistrict(new District("Улуг-Хемский"));
        districtService.saveDistrict(new District("Чаа-Хольский"));
        districtService.saveDistrict(new District("Чеди-Хольский"));
        districtService.saveDistrict(new District("Эрзинский"));
        districtService.saveDistrict(new District("Городские округа"));

        District district = districtService.getDistrictById(1);
        settlementService.saveSettlement(new Settlement("Тээли", district));
        settlementService.saveSettlement(new Settlement("Бай-Тал", district));
        settlementService.saveSettlement(new Settlement("Кызыл-Даг", district));
        settlementService.saveSettlement(new Settlement("Кара-Холь", district));
        settlementService.saveSettlement(new Settlement("Хемчик", district));
        settlementService.saveSettlement(new Settlement("Шуй", district));
        settlementService.saveSettlement(new Settlement("Ээр-Хавак", district));

        district = districtService.getDistrictById(2);
        settlementService.saveSettlement(new Settlement("Кызыл-Мажалык", district));
        settlementService.saveSettlement(new Settlement("Аксы-Барлык", district));
        settlementService.saveSettlement(new Settlement("Аянгаты", district));
        settlementService.saveSettlement(new Settlement("Барлык", district));
        settlementService.saveSettlement(new Settlement("Бижиктиг-Хая", district));
        settlementService.saveSettlement(new Settlement("Ак", district));
        settlementService.saveSettlement(new Settlement("Хонделен", district));
        settlementService.saveSettlement(new Settlement("Шекпээр", district));
        settlementService.saveSettlement(new Settlement("Эрги-Барлык", district));

        district = districtService.getDistrictById(3);
        settlementService.saveSettlement(new Settlement("Чадана", district));
        settlementService.saveSettlement(new Settlement("Баян-Тала", district));
        settlementService.saveSettlement(new Settlement("Чадан", district));
        settlementService.saveSettlement(new Settlement("Ийме", district));
        settlementService.saveSettlement(new Settlement("Теве-Хая", district));
        settlementService.saveSettlement(new Settlement("Хорум-Даг", district));
        settlementService.saveSettlement(new Settlement("Хайыракан", district));
        settlementService.saveSettlement(new Settlement("Хондергей", district));
        settlementService.saveSettlement(new Settlement("Чыраа-Бажы", district));
        settlementService.saveSettlement(new Settlement("Чыргакы", district));
        settlementService.saveSettlement(new Settlement("Элдиг-Хем", district));
        settlementService.saveSettlement(new Settlement("Шеми", district));

        district = districtService.getDistrictById(4);
        settlementService.saveSettlement(new Settlement("Сарыг-Сеп", district));
        settlementService.saveSettlement(new Settlement("Бояровка", district));
        settlementService.saveSettlement(new Settlement("Бурен-Хем", district));
        settlementService.saveSettlement(new Settlement("Бурен-Бай-Хаак", district));
        settlementService.saveSettlement(new Settlement("Дерзиг-Аксы", district));
        settlementService.saveSettlement(new Settlement("Ильинка", district));
        settlementService.saveSettlement(new Settlement("Кундустуг", district));
        settlementService.saveSettlement(new Settlement("Кок-Хаак", district));
        settlementService.saveSettlement(new Settlement("Сизим", district));
        settlementService.saveSettlement(new Settlement("Суг-Бажы", district));
        settlementService.saveSettlement(new Settlement("Усть-Бурен", district));

        district = districtService.getDistrictById(5);
        settlementService.saveSettlement(new Settlement("Баян-Кол", district));
        settlementService.saveSettlement(new Settlement("Кара-Хаак", district));
        settlementService.saveSettlement(new Settlement("Сукпак", district));
        settlementService.saveSettlement(new Settlement("Терлиг-Хая", district));
        settlementService.saveSettlement(new Settlement("Усть-Элегест", district));
        settlementService.saveSettlement(new Settlement("Целинное", district));
        settlementService.saveSettlement(new Settlement("Черби", district));
        settlementService.saveSettlement(new Settlement("Шамбалыг", district));
        settlementService.saveSettlement(new Settlement("Ээрбек", district));
        settlementService.saveSettlement(new Settlement("пгт Каа-Хем", district));

        district = districtService.getDistrictById(6);
        settlementService.saveSettlement(new Settlement("Каргы", district));
        settlementService.saveSettlement(new Settlement("Моген-Бурен", district));
        settlementService.saveSettlement(new Settlement("Тоолайлыг", district));

        district = districtService.getDistrictById(7);
        settlementService.saveSettlement(new Settlement("Хандагайты", district));
        settlementService.saveSettlement(new Settlement("Дус-Даг", district));
        settlementService.saveSettlement(new Settlement("Саглы", district));
        settlementService.saveSettlement(new Settlement("Солчур", district));
        settlementService.saveSettlement(new Settlement("Сарыг-Холь", district));
        settlementService.saveSettlement(new Settlement("Чаа-Суур", district));

        district = districtService.getDistrictById(8);
        settlementService.saveSettlement(new Settlement("Туран", district));
        settlementService.saveSettlement(new Settlement("Аржаан", district));
        settlementService.saveSettlement(new Settlement("Севи", district));
        settlementService.saveSettlement(new Settlement("Сесерлиг", district));
        settlementService.saveSettlement(new Settlement("Суш", district));
        settlementService.saveSettlement(new Settlement("Тарлаг", district));
        settlementService.saveSettlement(new Settlement("Уюк", district));
        settlementService.saveSettlement(new Settlement("Хадын", district));

        district = districtService.getDistrictById(9);
        settlementService.saveSettlement(new Settlement("Суг-Аксы", district));
        settlementService.saveSettlement(new Settlement("Алдан-Маадыр", district));
        settlementService.saveSettlement(new Settlement("Ак-Даш", district));
        settlementService.saveSettlement(new Settlement("Бора-Тайга", district));
        settlementService.saveSettlement(new Settlement("Кара-Чыраа", district));
        settlementService.saveSettlement(new Settlement("Кызыл-Тайга", district));
        settlementService.saveSettlement(new Settlement("Ишкин", district));

        district = districtService.getDistrictById(10);
        settlementService.saveSettlement(new Settlement("Бай-Хаак", district));
        settlementService.saveSettlement(new Settlement("Арыг-Бажы", district));
        settlementService.saveSettlement(new Settlement("Балгазын", district));
        settlementService.saveSettlement(new Settlement("Дурген", district));
        settlementService.saveSettlement(new Settlement("Кочетово", district));
        settlementService.saveSettlement(new Settlement("Кызыл-Арыг", district));
        settlementService.saveSettlement(new Settlement("Межегей", district));
        settlementService.saveSettlement(new Settlement("Успенка", district));

        district = districtService.getDistrictById(11);
        settlementService.saveSettlement(new Settlement("Шынаа", district));
        settlementService.saveSettlement(new Settlement("Каргы", district));
        settlementService.saveSettlement(new Settlement("Балыктыг", district));
        settlementService.saveSettlement(new Settlement("Эми", district));

        district = districtService.getDistrictById(12);
        settlementService.saveSettlement(new Settlement("Самагалтай", district));
        settlementService.saveSettlement(new Settlement("Кызыл-Чыраа", district));
        settlementService.saveSettlement(new Settlement("Берт-Даг", district));
        settlementService.saveSettlement(new Settlement("О-Шынаа", district));
        settlementService.saveSettlement(new Settlement("У-Шынаа", district));
        settlementService.saveSettlement(new Settlement("Чыргаланды", district));
        settlementService.saveSettlement(new Settlement("Шуурмак", district));

        district = districtService.getDistrictById(13);
        settlementService.saveSettlement(new Settlement("Тоора-Хем", district));
        settlementService.saveSettlement(new Settlement("Азас", district));
        settlementService.saveSettlement(new Settlement("Ий", district));
        settlementService.saveSettlement(new Settlement("Сыстыг-Хем", district));
        settlementService.saveSettlement(new Settlement("Чазылары", district));
        settlementService.saveSettlement(new Settlement("Ырбан", district));

        district = districtService.getDistrictById(14);
        settlementService.saveSettlement(new Settlement("Шагонар", district));
        settlementService.saveSettlement(new Settlement("Кок-Чыраа", district));
        settlementService.saveSettlement(new Settlement("Арыскан", district));
        settlementService.saveSettlement(new Settlement("Арыг-Узуу", district));
        settlementService.saveSettlement(new Settlement("Иштии-Хем", district));
        settlementService.saveSettlement(new Settlement("Ийи-Тал", district));
        settlementService.saveSettlement(new Settlement("Торгалыг", district));
        settlementService.saveSettlement(new Settlement("Хайыракан", district));
        settlementService.saveSettlement(new Settlement("Чааты", district));
        settlementService.saveSettlement(new Settlement("Эйлиг-Хем", district));

        district = districtService.getDistrictById(15);
        settlementService.saveSettlement(new Settlement("Чаа-Холь", district));
        settlementService.saveSettlement(new Settlement("Ак-Дуруг", district));
        settlementService.saveSettlement(new Settlement("Кызыл-Даг", district));
        settlementService.saveSettlement(new Settlement("Шанчы", district));

        district = districtService.getDistrictById(16);
        settlementService.saveSettlement(new Settlement("Хову-Аксы", district));
        settlementService.saveSettlement(new Settlement("Сайлыг", district));
        settlementService.saveSettlement(new Settlement("Хендерге", district));
        settlementService.saveSettlement(new Settlement("Холчук", district));
        settlementService.saveSettlement(new Settlement("Чал-Кежиг", district));
        settlementService.saveSettlement(new Settlement("Элегест", district));

        district = districtService.getDistrictById(17);
        settlementService.saveSettlement(new Settlement("Эрзин", district));
        settlementService.saveSettlement(new Settlement("Бай-Даг", district));
        settlementService.saveSettlement(new Settlement("Морен", district));
        settlementService.saveSettlement(new Settlement("Нарын", district));
        settlementService.saveSettlement(new Settlement("Качык", district));
        settlementService.saveSettlement(new Settlement("Сарыг-Булун", district));

        district = districtService.getDistrictById(18);
        settlementService.saveSettlement(new Settlement("Кызыл", district));
        settlementService.saveSettlement(new Settlement("Кызыл (ЛДО)", district));
        settlementService.saveSettlement(new Settlement("Кызыл (ПДО)", district));
        settlementService.saveSettlement(new Settlement("Кызыл (Вавилинский)", district));
        settlementService.saveSettlement(new Settlement("Ак-Довурак", district));

        questionService.questionSave(new Question("Где проживает Ваша семья:", "radioType"));

        questionService.questionSave(new Question("Сколько человек в Вашей семье?", "textType"));

        Question question = questionService.questionSave(new Question("Состоите ли Вы в браке?", "radioType"));
        answerService.saveAnswer(new Answer("в зарегистрированном браке", question));
        answerService.saveAnswer(new Answer("в незарегистрированном браке(гражданский брак)", question));
        answerService.saveAnswer(new Answer("разведен(а) официально (развод зарегистрирован)", question));
        answerService.saveAnswer(new Answer("разошелся(лась), развод не зарегистрирован", question));
        answerService.saveAnswer(new Answer("вдова/вдовец", question));
        answerService.saveAnswer(new Answer("никогда не состоял(а) в браке (в зарегистрированном или незарегистрированном)", question));

        question = questionService.questionSave(new Question("Укажите состав Вашей семьи: Совместно проживающие члены семьи:", "radioType"));
        answerService.saveAnswer(new Answer("Глава семьи", question));
        answerService.saveAnswer(new Answer("Муж/Жена", question));
        answerService.saveAnswer(new Answer("Сын/Дочь", question));
        answerService.saveAnswer(new Answer("Отец/Мать", question));
        answerService.saveAnswer(new Answer("Брат/Сестра", question));
        answerService.saveAnswer(new Answer("Дедушка/Бабушка", question));
        answerService.saveAnswer(new Answer("Теща/свекровь", question));
        answerService.saveAnswer(new Answer("Тесть/свекор", question));
        answerService.saveAnswer(new Answer("Деверь/шурин", question));
        answerService.saveAnswer(new Answer("Золовка/своячница", question));
        answerService.saveAnswer(new Answer("Свояки", question));
        answerService.saveAnswer(new Answer("Племнянники", question));
        answerService.saveAnswer(new Answer("Отчим/Мачеха", question));
        answerService.saveAnswer(new Answer("Зять/Невестка", question));
        answerService.saveAnswer(new Answer("Дядя/Тетя", question));
        answerService.saveAnswer(new Answer("Сват/Сватья", question));
        answerService.saveAnswer(new Answer("Кузен/Кузина", question));

        questionService.questionSave(new Question("Возраст (количество полных лет):", "textType"));

        question = questionService.questionSave(new Question("Пол:", "radioType"));
        answerService.saveAnswer(new Answer("м", question));
        answerService.saveAnswer(new Answer("ж", question));

        question = questionService.questionSave(new Question("Занятость членов семьи:", "radioType"));
        answerService.saveAnswer(new Answer("работает", question));
        answerService.saveAnswer(new Answer("безработный", question));
        answerService.saveAnswer(new Answer("предприниматель", question));
        answerService.saveAnswer(new Answer("состоит на учете ЦЗН", question));
        answerService.saveAnswer(new Answer("пропустить", question));

        question = questionService.questionSave(new Question("Занятость членов семьи для детей:", "radioType"));
        answerService.saveAnswer(new Answer("неорганизованный (не ходит в я/с)", question));
        answerService.saveAnswer(new Answer("организованный (ходит в я/с)", question));
        answerService.saveAnswer(new Answer("школьник, студент", question));
        answerService.saveAnswer(new Answer("пропустить", question));

        question = questionService.questionSave(new Question("Социальный статус:", "radioType"));
        answerService.saveAnswer(new Answer("пенсионер", question));
        answerService.saveAnswer(new Answer("инвалид", question));
        answerService.saveAnswer(new Answer("находится под опекой (попечительством)", question));
        answerService.saveAnswer(new Answer("мать (отец) одиночка", question));
        answerService.saveAnswer(new Answer("пропустить", question));

        question = questionService.questionSave(new Question("Укажите образование совершеннолетних членов Вашей семьи:", "radioType"));
        answerService.saveAnswer(new Answer("высшее образование, в том числе бакалавриат, магистратура", question));
        answerService.saveAnswer(new Answer("незаконченное высшее (3 курса ВУЗа)", question));
        answerService.saveAnswer(new Answer("среднее специальное (техникум, колледж, ПУ)", question));
        answerService.saveAnswer(new Answer("среднее общее (10/11 классов)", question));
        answerService.saveAnswer(new Answer("неполное среднее (8/9 классов)", question));
        answerService.saveAnswer(new Answer("начальное образование (1-4 классов)", question));
        answerService.saveAnswer(new Answer("не имеет начального образования", question));

        question = questionService.questionSave(new Question("Укажите основной вид деятельности членов Вашей семьи (для находящихся в отпуске по беременности и родам или по уходу за ребенком – вид деятельности до отпуска)", "radioType"));
        answerService.saveAnswer(new Answer("официально работает на предприятии, в организации в Республике Тыва", question));
        answerService.saveAnswer(new Answer("официально работает за пределами республики", question));
        answerService.saveAnswer(new Answer("работает без официального трудоустройства на предприятии, организации", question));
        answerService.saveAnswer(new Answer("нет постоянной работы, но есть случайные нерегулярные заработки", question));
        answerService.saveAnswer(new Answer("индивидуальный предприниматель", question));
        answerService.saveAnswer(new Answer("всегда занималась (занимался) только домом, никогда не работал и не ищу работу", question));
        answerService.saveAnswer(new Answer("раньше работала, сейчас не работаю, ищу работу", question));
        answerService.saveAnswer(new Answer("работал(а), но сейчас не работаю и не собираюсь в ближайшее время", question));
        answerService.saveAnswer(new Answer("занимаюсь только личным подсобным или приусадебным хозяйством", question));
        answerService.saveAnswer(new Answer("неработающий, состоит на учете в ЦЗН", question));
        answerService.saveAnswer(new Answer("временно или длительно нетрудоспособный (инвалидность)", question));
        answerService.saveAnswer(new Answer("осуществляет уход за престарелым/инвалидом/ребенком-инвалидом", question));
        answerService.saveAnswer(new Answer("до отпуска", question));

        question = questionService.questionSave(new Question("В какой отрасли работают члены вашей семьи?", "radioType"));
        answerService.saveAnswer(new Answer("промышленность", question));
        answerService.saveAnswer(new Answer("строительство", question));
        answerService.saveAnswer(new Answer("транспорт и связь", question));
        answerService.saveAnswer(new Answer("торговля", question));
        answerService.saveAnswer(new Answer("общественное питание", question));
        answerService.saveAnswer(new Answer("жилищно-коммунальное хозяйство", question));
        answerService.saveAnswer(new Answer("культура, искусство", question));
        answerService.saveAnswer(new Answer("государственная (муниципальная) служба", question));
        answerService.saveAnswer(new Answer("силовые структуры", question));
        answerService.saveAnswer(new Answer("военные структуры", question));
        answerService.saveAnswer(new Answer("образование, наука", question));
        answerService.saveAnswer(new Answer("сельское хозяйство", question));
        answerService.saveAnswer(new Answer("финансы,кредит, страхование", question));
        answerService.saveAnswer(new Answer("здравоохранение", question));
        answerService.saveAnswer(new Answer("социальная защита", question));
        answerService.saveAnswer(new Answer("сфера услуг", question));

        question = questionService.questionSave(new Question("К какой группе работников относятся члены Вашей семьи?", "radioType"));
        answerService.saveAnswer(new Answer("руководитель", question));
        answerService.saveAnswer(new Answer("высоко квалифицированный специалист (должность предполагает высшее образование)", question));
        answerService.saveAnswer(new Answer("служащий из числа технического и обслуживающего персонала (повар, няня и т.п.)", question));
        answerService.saveAnswer(new Answer("военнослужащий", question));
        answerService.saveAnswer(new Answer("квалифицированный рабочий", question));
        answerService.saveAnswer(new Answer("неквалифицированный рабочий (разнорабочий, техничка и т.п.)", question));

        question = questionService.questionSave(new Question("Имеют ли подработку, приносящую дополнительный заработок, члены Вашей семьи?", "checkType"));
        answerService.saveAnswer(new Answer("присмотр и уход (за больными детьми; за больными достигшими возраста 80 лет; за иными лицами, нуждающимися в постоянном постороннем уходе по заключению медицинской организации)", question));
        answerService.saveAnswer(new Answer("репетиторство", question));
        answerService.saveAnswer(new Answer("уборка жилых помещений, ведение домашнего хозяйства", question));
        answerService.saveAnswer(new Answer("по выпасу скота", question));
        answerService.saveAnswer(new Answer("по стрижке овец", question));
        answerService.saveAnswer(new Answer("по пошиву и ремонту одежды", question));
        answerService.saveAnswer(new Answer("по текущему ремонту жилых помещений", question));
        answerService.saveAnswer(new Answer("по изготовлению фотографий", question));
        answerService.saveAnswer(new Answer("по организации и проведению обрядов (свадеб, юбилеев), в т.ч. по музыкальному сопровождению", question));
        answerService.saveAnswer(new Answer("по организации и проведению экскурсий гидами и экскурсоводами", question));
        answerService.saveAnswer(new Answer("тренеров и инструкторов по фитнесу и бодифитнесу", question));
        answerService.saveAnswer(new Answer("от предоставления собственных услуг (от стрижки и укладки волос, от наращивания ресниц и оформлению бровей, фото-видео услуги и т.п.)", question));
        answerService.saveAnswer(new Answer("пропустить", question));

        question = questionService.questionSave(new Question("Что предпринимали члены вашей семьи для поиска работы?", "checkType"));
        answerService.saveAnswer(new Answer("работу не искал(а)", question));
        answerService.saveAnswer(new Answer("обращался(ась) к друзьям, родным, знакомым", question));
        answerService.saveAnswer(new Answer("встал(а) на учет в службу занятости", question));
        answerService.saveAnswer(new Answer("обращался(ась) непосредственно на предприятие, к работодателю", question));
        answerService.saveAnswer(new Answer("пытался(ась) организовать собственное дело", question));
        answerService.saveAnswer(new Answer("слежу за информацией о вакансиях по объявлениям  в газете, по радио, в интернете", question));

        question = questionService.questionSave(new Question("Зарегистрированы ли безработные члены вашей семьи в службе занятости?", "radioType"));
        answerService.saveAnswer(new Answer("да, имею официальный статус безработного", question));
        answerService.saveAnswer(new Answer("да, состою на учете, но без статуса безработного", question));
        answerService.saveAnswer(new Answer("нет, но собираюсь обратиться в службу занятости", question));
        answerService.saveAnswer(new Answer("не вижу необходимости в регистрации", question));

        question = questionService.questionSave(new Question("Какое требование к работе является важным для членов Вашей семьи", "checkType"));
        answerService.saveAnswer(new Answer("подходящий заработок", question));
        answerService.saveAnswer(new Answer("соответствие профессии, специальности", question));
        answerService.saveAnswer(new Answer("удобный режим работы", question));
        answerService.saveAnswer(new Answer("содержательная работа с нормальными условиями труда", question));
        answerService.saveAnswer(new Answer("близость к дому", question));
        answerService.saveAnswer(new Answer("перспективы профессионального и должностного роста", question));
        answerService.saveAnswer(new Answer("устроит любая работа", question));

        question = questionService.questionSave(new Question("Перечислите ежемесячные постоянные доходы Вашей семьи:", "checkType"));
        answerService.saveAnswer(new Answer("заработная плата в денежной форме", question));
        answerService.saveAnswer(new Answer("доход от предпринимательской деятельности", question));
        answerService.saveAnswer(new Answer("доход от сдачи собственности в аренду", question));
        answerService.saveAnswer(new Answer("пенсия всех видов", question));
        answerService.saveAnswer(new Answer("пособие по безработице", question));
        answerService.saveAnswer(new Answer("алименты", question));
        answerService.saveAnswer(new Answer("стипендии", question));
        answerService.saveAnswer(new Answer("пособия на детей", question));
        answerService.saveAnswer(new Answer("другие денежные субсидии (ЖКХ), компенсации(род. плата)", question));

        question = questionService.questionSave(new Question("Перечислите периодические доходы Вашей семьи:", "checkType"));
        answerService.saveAnswer(new Answer("доходы от продажи продуктов с ЛПХ, собранных грибов, ягод, продуктов охоты, рыболовства", question));
        answerService.saveAnswer(new Answer("страховые возмещения (пособия по временной нетрудоспособности)", question));
        answerService.saveAnswer(new Answer("деньги, подарки, вещи от родственников, других частных лиц", question));
        answerService.saveAnswer(new Answer("помощь благотворительных фондов", question));
        answerService.saveAnswer(new Answer("выигрыши в лотореи и прочие игры", question));
        answerService.saveAnswer(new Answer("доходы от предоставления собственных услуг (от стрижки и укладки волос, от наращивания ресниц и оформлению бровей, от проведения свадеб, фото-видео услуги и т.п.)", question));
        answerService.saveAnswer(new Answer("пропустить", question));

        questionService.questionSave(new Question("Сколько составляет общий доход  ВСЕХ членов Вашей семьи в месяц (в рублях)?", "textType"));

        question = questionService.questionSave(new Question("Перечислите основные ежемесячные расходы Вашей семьи (основные траты):", "textType"));
        answerService.saveAnswer(new Answer("питание", question));
        answerService.saveAnswer(new Answer("оплата жилья и коммунальных услуг", question));
        answerService.saveAnswer(new Answer("оплата за сад, обучение, секции", question));
        answerService.saveAnswer(new Answer("приобретение одежды, обуви", question));
        answerService.saveAnswer(new Answer("приобретение лекарств, оплата лечения, анализов", question));
        answerService.saveAnswer(new Answer("оплата долгов 3-м лицам", question));
        answerService.saveAnswer(new Answer("содержание личного транспорта", question));
        answerService.saveAnswer(new Answer("оплата кредита, займа, ссуды", question));
        answerService.saveAnswer(new Answer("развлечения: театр, кино, прогулки и пр.", question));
        answerService.saveAnswer(new Answer("ведения ЛПХ (приобретение удобрений, кормов, с/х инвентаря, семян и пр.", question));

        questionService.questionSave(new Question("Общий расход ВСЕХ членов Вашей семьи в месяц (в рублях)?", "textType"));

        question = questionService.questionSave(new Question("Какое из перечисленных описаний точнее всего соответствует материальному положению Вашей семьи:", "radioType"));
        answerService.saveAnswer(new Answer("денег не хватает даже на питание", question));
        answerService.saveAnswer(new Answer("денег хватает только на питание", question));
        answerService.saveAnswer(new Answer("на питание и одежду денег хватает, но более крупные покупки приходится откладывать на потом", question));
        answerService.saveAnswer(new Answer("денег вполне хватает на покупку крупной бытовой техники, но мы не можем купить автомашину, дач", question));
        answerService.saveAnswer(new Answer("денег хватает на все, кроме таких дорогих приобретений, как квартира, дом", question));
        answerService.saveAnswer(new Answer("мы можем позволить себе купить машину, дачу, словом ни в чем себе не отказываем", question));

        question = questionService.questionSave(new Question("Какова причина того, что Ваша семья имеет низкие доходы", "checkType"));
        answerService.saveAnswer(new Answer("низкий уровень оплаты труда", question));
        answerService.saveAnswer(new Answer("отсутствие работы (подработки) по месту жительства", question));
        answerService.saveAnswer(new Answer("ухаживаю за больным членом семьи", question));
        answerService.saveAnswer(new Answer("много несовершеннолетних в семье", question));
        answerService.saveAnswer(new Answer("не хочу работать за низкую зарплату", question));
        answerService.saveAnswer(new Answer("низкая квалификация (отсутствие среднего специального или высшего образования)", question));
        answerService.saveAnswer(new Answer("не позволяет работать состояние здоровья", question));
        answerService.saveAnswer(new Answer("высокие цены на продукты питания и вещи", question));
        answerService.saveAnswer(new Answer("отсутствие точек сбыта для реализации продукции с ЛПХ", question));
        answerService.saveAnswer(new Answer("невысокий размер социальных выплат и пособий", question));
        answerService.saveAnswer(new Answer("бездействие органов местного самоуправления", question));

        question = questionService.questionSave(new Question("Откладывают ли сбережения в вашей семье?", "radioType"));
        answerService.saveAnswer(new Answer("да, ежемесячно", question));
        answerService.saveAnswer(new Answer("от случая к случаю", question));
        answerService.saveAnswer(new Answer("нет, не хватает денег даже на текущие расходы", question));
        answerService.saveAnswer(new Answer("приходится брать деньги в долг (постоянно, изредка)", question));

        question = questionService.questionSave(new Question("Приходилось ли Вам брать деньги в долг, если да, то почему?", "checkType"));
        answerService.saveAnswer(new Answer("на самые необходимые расходы: еда, оплата жилья и коммунальных услуг, лекарства", question));
        answerService.saveAnswer(new Answer("на экстренный ремонт жилья (транспортного средства)", question));
        answerService.saveAnswer(new Answer("на ремонт и покупку (замену) телевизора, холодильника, простой мебели", question));
        answerService.saveAnswer(new Answer("приобретение самых необходимых лекарств и медикаментов, оплату экстренной медпомощи", question));
        answerService.saveAnswer(new Answer("на оплату кредитов, займов", question));
        answerService.saveAnswer(new Answer("не одалживаю денег ни у кого", question));

        question = questionService.questionSave(new Question("Какая примерно часть общего суммарного бюджета семьи ежемесячно уходит на питание", "radioType"));
        answerService.saveAnswer(new Answer("менее половины", question));
        answerService.saveAnswer(new Answer("примерно половина", question));
        answerService.saveAnswer(new Answer("примерно две трети", question));
        answerService.saveAnswer(new Answer("почти все", question));

        question = questionService.questionSave(new Question("Отметьте, на что способна Ваша семья", "checkType"));
        answerService.saveAnswer(new Answer("на отложенные деньги поехать в отпуск за пределы республики раз в год", question));
        answerService.saveAnswer(new Answer("своевременно погасить задолженности (по ипотеке, кредитам, коммунальным платежам", question));
        answerService.saveAnswer(new Answer("позволить себе компьютер и доступ к Интернету", question));
        answerService.saveAnswer(new Answer("за свой счет регулярно (1 раза в месяц) участвовать в мероприятиях досуга и отдыха", question));
        answerService.saveAnswer(new Answer("купить новую одежду", question));
        answerService.saveAnswer(new Answer("сходить в кафе/ ресторан 1 раз в неделю/1 раз в месяц", question));
        answerService.saveAnswer(new Answer("тратить деньги в пределах 1000 руб. на собственные нужды каждую неделю", question));
        answerService.saveAnswer(new Answer("пропустить", question));

        question = questionService.questionSave(new Question("Предполагаете ли Вы улучшить существующее материальное положение?", "radioType"));
        answerService.saveAnswer(new Answer("да", question));
        answerService.saveAnswer(new Answer("нет", question));

        question = questionService.questionSave(new Question("Что из ниже перечисленного Вы предпринимаете для того, чтобы изменить материальное благосостояние самого себя и своей семьи?", "checkType"));
        answerService.saveAnswer(new Answer("поменять место работы", question));
        answerService.saveAnswer(new Answer("найти дополнительную подработку", question));
        answerService.saveAnswer(new Answer("открыть собственное дело/предпринимательство", question));
        answerService.saveAnswer(new Answer("получить от органов власти поддержку (участие в губернаторских проектах, получение субсидирования в виде денег)", question));
        answerService.saveAnswer(new Answer("переквалифицировался (ась) на мастера по массажу, макияжу и маникюра", question));
        answerService.saveAnswer(new Answer("пройти повышение квалификации", question));
        answerService.saveAnswer(new Answer("заняться скотоводством, рыболовством и собирательством", question));
        answerService.saveAnswer(new Answer("переехать в другой район, либо город", question));

        question = questionService.questionSave(new Question("Каким видом промысла занимается Ваша семья?", "checkType"));
        answerService.saveAnswer(new Answer("собирательство (ягоды, грибы, шишки и т.д)", question));
        answerService.saveAnswer(new Answer("охотничий промысел", question));
        answerService.saveAnswer(new Answer("рыболовство", question));
        answerService.saveAnswer(new Answer("не занимаемся промыслом", question));

        question = questionService.questionSave(new Question("Как Вы оцениваете роль промысла для Вашей семьи?", "checkType"));
        answerService.saveAnswer(new Answer("основной источник питания для нашей семьи", question));
        answerService.saveAnswer(new Answer("дополнительный источник питания и денежных доходов от продажи продукции", question));

        question = questionService.questionSave(new Question("Как вы оцениваете значение личного подсобного хозяйства для бюджета Вашей семьи?", "radioType"));
        answerService.saveAnswer(new Answer("основной источник питания для нашей семьи", question));
        answerService.saveAnswer(new Answer("дополнительный источник питания и денежных доходов от продажи продукции", question));
        answerService.saveAnswer(new Answer("не имеем ЛПХ", question));
        answerService.saveAnswer(new Answer("никакого значения не имеет", question));

        question = questionService.questionSave(new Question("При наличии ЛПХ - укажите сферу деятельности:", "checkType"));
        answerService.saveAnswer(new Answer("растениеводство", question));
        answerService.saveAnswer(new Answer("животноводство", question));
        answerService.saveAnswer(new Answer("смешанное хозяйство", question));

        question = questionService.questionSave(new Question("Ваша семья держит ли сельскохозяйственных животных?", "textType"));
        answerService.saveAnswer(new Answer("КРС", question));
        answerService.saveAnswer(new Answer("МРС", question));
        answerService.saveAnswer(new Answer("лошади", question));
        answerService.saveAnswer(new Answer("свиньи", question));
        answerService.saveAnswer(new Answer("куры/гуси", question));
        answerService.saveAnswer(new Answer("яки", question));
        answerService.saveAnswer(new Answer("верблюды", question));
        answerService.saveAnswer(new Answer("олени", question));
        answerService.saveAnswer(new Answer("не держит", question));

        question = questionService.questionSave(new Question("Укажите, пожалуйста, с кем и в каких жилищных условиях живете?", "radioType"));
        answerService.saveAnswer(new Answer("собственный частный дом", question));
        answerService.saveAnswer(new Answer("приватизированная квартира", question));
        answerService.saveAnswer(new Answer("живем с родителями, родственниками", question));
        answerService.saveAnswer(new Answer("снимаем комнату в коммунальной квартире, времянку", question));
        answerService.saveAnswer(new Answer("снимаем квартиру, дом", question));
        answerService.saveAnswer(new Answer("живем в общежитии", question));
        answerService.saveAnswer(new Answer("ипотечное жилье", question));

        question = questionService.questionSave(new Question("Есть ли перед Вашей семьей остро стоит жилищный вопрос, как Вы его решаете?", "checkType"));
        answerService.saveAnswer(new Answer("коплю на покупку/стройку собственного жилья", question));
        answerService.saveAnswer(new Answer("буду оформлять кредит на благоустройство имеющегося квартиры/дома/дачи, так как нет возможности копить на новое жильё", question));
        answerService.saveAnswer(new Answer("стою в очереди, чтобы получить дом/квартиру", question));
        answerService.saveAnswer(new Answer("оформляю ипотеку/кредит, чтобы улучшить жилищные условия", question));
        answerService.saveAnswer(new Answer("рассчитываю получить наследство", question));
        answerService.saveAnswer(new Answer("никак не решаю из-за финансовых возможностей", question));
        answerService.saveAnswer(new Answer("не имею проблем с жильем", question));

        question = questionService.questionSave(new Question("Имеет ли Ваша семья (кто-нибудь из членов Вашей семьи) еще одно недвижимое имущество:", "checkType"));
        answerService.saveAnswer(new Answer("отдельная квартира", question));
        answerService.saveAnswer(new Answer("индивидуальный дом", question));
        answerService.saveAnswer(new Answer("комната (несколько комнат) в общежитии (квартире)", question));
        answerService.saveAnswer(new Answer("дача/коллективный огород", question));
        answerService.saveAnswer(new Answer("гараж стационарный/бокс", question));
        answerService.saveAnswer(new Answer("земельный участок", question));
        answerService.saveAnswer(new Answer("пропустить", question));

        question = questionService.questionSave(new Question("Какие предметы длительного пользования и в каком количестве имеются в Вашей семье:", "textType"));
        answerService.saveAnswer(new Answer("холодильник", question));
        answerService.saveAnswer(new Answer("плита (газовая, электрическая)", question));
        answerService.saveAnswer(new Answer("духовой шкаф", question));
        answerService.saveAnswer(new Answer("посудомоечная машина", question));
        answerService.saveAnswer(new Answer("стиральная машина", question));
        answerService.saveAnswer(new Answer("швейная машинка", question));
        answerService.saveAnswer(new Answer("электроутюг", question));
        answerService.saveAnswer(new Answer("пылесос", question));
        answerService.saveAnswer(new Answer("кондиционер", question));
        answerService.saveAnswer(new Answer("телевизор", question));
        answerService.saveAnswer(new Answer("компьютер/ноутбук", question));
        answerService.saveAnswer(new Answer("ноутбук и пр", question));
        answerService.saveAnswer(new Answer("домашний кинотеатр", question));
        answerService.saveAnswer(new Answer("фотоаппарат", question));
        answerService.saveAnswer(new Answer("стационарный телефон", question));
        answerService.saveAnswer(new Answer("кнопочный телефон", question));
        answerService.saveAnswer(new Answer("Смартфон", question));
        answerService.saveAnswer(new Answer("iPhone", question));

        question = questionService.questionSave(new Question("Сколько каналов Вы смотрите?", "radioType"));
        answerService.saveAnswer(new Answer("1-5 каналов", question));
        answerService.saveAnswer(new Answer("6-10 каналов", question));
        answerService.saveAnswer(new Answer("11-15 каналов", question));
        answerService.saveAnswer(new Answer("16-20 каналов", question));
        answerService.saveAnswer(new Answer("более 20 каналов", question));
        answerService.saveAnswer(new Answer("нет телевизора", question));

        question = questionService.questionSave(new Question("Имеются ли в распоряжении Вашей семьи транспортные средства, укажите их количество:", "textType"));
        answerService.saveAnswer(new Answer("легковой автомобиль", question));
        answerService.saveAnswer(new Answer("автобус/ микроавтобус", question));
        answerService.saveAnswer(new Answer("грузовой автомобиль", question));
        answerService.saveAnswer(new Answer("моторная лодка/катер", question));
        answerService.saveAnswer(new Answer("снегоход/мотоцикл/мопед", question));
        answerService.saveAnswer(new Answer("не имеем транспортные средства", question));

        question = questionService.questionSave(new Question("Если имеется, укажите год выпуска транспортных средств:", "radioType"));
        answerService.saveAnswer(new Answer("до 2000 г/в.", question));
        answerService.saveAnswer(new Answer("2000 г/в. и выше", question));

        question = questionService.questionSave(new Question("Как Вы оцените здоровье членов Вашей семьи?", "radioType"));
        answerService.saveAnswer(new Answer("в основном здоровы", question));
        answerService.saveAnswer(new Answer("в семье имеются инвалид(ы)", question));
        answerService.saveAnswer(new Answer("часто болеют дети", question));
        answerService.saveAnswer(new Answer("болеют редко", question));
        answerService.saveAnswer(new Answer("имеются больные с хроническими заболеваниями", question));

        question = questionService.questionSave(new Question("Где лечатся члены Вашей семьи", "radioType"));
        answerService.saveAnswer(new Answer("в поликлинике/ФАП по месту жительства", question));
        answerService.saveAnswer(new Answer("в платной клинике", question));
        answerService.saveAnswer(new Answer("не обращаюсь в больницу", question));
        answerService.saveAnswer(new Answer("не хватает денег оплатить дорогу в больницу", question));

        question = questionService.questionSave(new Question("За последний год обращался ли кто-либо из членов Вашей семьи за медпомощью к платным врачам?", "radioType"));
        answerService.saveAnswer(new Answer("не было необходимости", question));
        answerService.saveAnswer(new Answer("да, так как нет бесплатных врачей такого профиля", question));
        answerService.saveAnswer(new Answer("к бесплатному невозможно попасть", question));
        answerService.saveAnswer(new Answer("не устроил прием бесплатного врача", question));

        question = questionService.questionSave(new Question("Если в течение года кто-либо из членов Вашей семьи обращался к врачу, было ли выполнено назначенное лечение (анализы, исследования, препараты и пр.)?", "radioType"));
        answerService.saveAnswer(new Answer("да, выполнили", question));
        answerService.saveAnswer(new Answer("выполнили частично, так как не хватило денег", question));
        answerService.saveAnswer(new Answer("приобрели дешевые аналоги выписанных лекарств", question));
        answerService.saveAnswer(new Answer("вообще не выполнили, нет денег", question));

        question = questionService.questionSave(new Question("Если в семье есть хронические больные/инвалиды, то обеспечиваются ли они необходимыми  лекарствами?", "radioType"));
        answerService.saveAnswer(new Answer("да, полностью, регулярно", question));
        answerService.saveAnswer(new Answer("нерегулярно, так как вынуждены экономить на этом", question));
        answerService.saveAnswer(new Answer("нет, на это нет денег", question));
        answerService.saveAnswer(new Answer("хронических больных нет", question));


        question = questionService.questionSave(new Question("Получала ли Ваша семья (кто-либо из членов Вашей семьи) помощь от отдельно живущих родителей, родственников, соседей, незнакомых людей (организация)?", "checkType"));
        answerService.saveAnswer(new Answer("регулярно деньгами", question));
        answerService.saveAnswer(new Answer("регулярно продуктами, вещами", question));
        answerService.saveAnswer(new Answer("помогли в получении (погашеннии) кредита/ипотеки", question));
        answerService.saveAnswer(new Answer("единовременно (при покупке жилья/техники/машины/оплата отдыха, лечения, учебы)", question));
        answerService.saveAnswer(new Answer("оказали помошь в трудоустройстве", question));
        answerService.saveAnswer(new Answer("время от времени деньгами/продуктами/вещами", question));
        answerService.saveAnswer(new Answer("помогают при стирке/уборке/починке одежды", question));
        answerService.saveAnswer(new Answer("помогают растить ребенка/ухаживать за членом семьи", question));
        answerService.saveAnswer(new Answer("оказывают профконсультации, иные услуги (медицинские, юридические и др.)", question));
        answerService.saveAnswer(new Answer("материальной помошь не получали", question));

        question = questionService.questionSave(new Question("Если получали, какую роль играет эта помощь в бюджете Вашей семьи?", "radioType"));
        answerService.saveAnswer(new Answer("без этого не смогли бы прожить", question));
        answerService.saveAnswer(new Answer("существенно", question));
        answerService.saveAnswer(new Answer("незначительно", question));
        answerService.saveAnswer(new Answer("никакой роли, просто традиция", question));

        question = questionService.questionSave(new Question("Оказывала ли Ваша семья помощь отдельно живущим родителям, родственникам, соседям", "radioType"));
        answerService.saveAnswer(new Answer("да", question));
        answerService.saveAnswer(new Answer("нет", question));

        question = questionService.questionSave(new Question("Случались ли в Вашей семье за последний год непредвиденные радостные (рождение ребенка и пр.) или печальные (похороны, операция и др.) события?", "radioType"));
        answerService.saveAnswer(new Answer("да", question));
        answerService.saveAnswer(new Answer("нет", question));

        question = questionService.questionSave(new Question("Укажите источники средств, которые Вы использовали на вышеуказанные события:", "checkType"));
        answerService.saveAnswer(new Answer("обошлись собственными силами", question));
        answerService.saveAnswer(new Answer("получили государственное пособие", question));
        answerService.saveAnswer(new Answer("получили помощь друзей/родственников", question));
        answerService.saveAnswer(new Answer("помощь предприятия", question));
        answerService.saveAnswer(new Answer("взяли в долг", question));

        question = questionService.questionSave(new Question("Как Вы считаете, что можно изменить в Вашем населенном пункте, чтобы преодолеть бедность вообще или повысить материальный достаток Вашей семьи?", "checkType"));
        answerService.saveAnswer(new Answer("создание новых (дополнительных) рабочих мест", question));
        answerService.saveAnswer(new Answer("повышение уровня заработной платы", question));
        answerService.saveAnswer(new Answer("строительство новых учреждений (школы, садиков и т.п.) и предприятий", question));
        answerService.saveAnswer(new Answer("изменение критериев социальных проектов (возраст, количества членов семьи и т.п.)", question));
        answerService.saveAnswer(new Answer("регулирование цен на продукты, бензин, уголь", question));
        answerService.saveAnswer(new Answer("реконструкция/строительство дорог(мостов)", question));
        answerService.saveAnswer(new Answer("строительство ж/д дороги", question));
        answerService.saveAnswer(new Answer("занятие животноводством/растениеводством", question));

        return "ok";
    }

}
