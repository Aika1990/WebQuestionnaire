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

    @GetMapping("/saveDatabase")
    public void setDatabase (Model model) throws ResourceNotFoundException {

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
        settlementService.saveSettlement(new Settlement("Ак-Довурак", district));


        questionService.questionSave(new Question("Где проживает Ваша семья:", "radioType"));

        questionService.questionSave(new Question("Сколько человек в Вашей семье?", "textType"));

        Question question  = questionService.questionSave(new Question("Состоите ли Вы в браке?", "radioType"));
        answerService.saveAnswer(new Answer("в зарегистрированном браке", question));
        answerService.saveAnswer(new Answer("в незарегистрированном браке(гражданский брак)", question));
        answerService.saveAnswer(new Answer("разведен(а) официально (развод зарегистрирован)", question));
        answerService.saveAnswer(new Answer("разошелся(лась), развод не зарегистрирован", question));
        answerService.saveAnswer(new Answer("вдова/вдовец", question));
        answerService.saveAnswer(new Answer("никогда не состоял(а) в браке (в зарегистрированном или незарегистрированном)", question));

        question = questionService.questionSave(new Question("Укажите состав Вашей семьи: Совместно проживающие члены семьи:", "radioType"));
        answerService.saveAnswer(new Answer("Муж/Жена", question));
        answerService.saveAnswer(new Answer("Сын/Дочь", question));
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
        answerService.saveAnswer(new Answer("дошкольник", question));
        answerService.saveAnswer(new Answer("школьник", question));
        answerService.saveAnswer(new Answer("студент", question));

        question = questionService.questionSave(new Question("Социальный статус:", "radioType"));
        answerService.saveAnswer(new Answer("пенсионер", question));
        answerService.saveAnswer(new Answer("инвалид", question));
        answerService.saveAnswer(new Answer("находится под опекой (попечительством)", question));
        answerService.saveAnswer(new Answer("пропустить", question));

        question = questionService.questionSave(new Question("Укажите образование совершеннолетних членов Вашей семьи:", "radioType"));
        answerService.saveAnswer(new Answer("высшее образование", question));
        answerService.saveAnswer(new Answer("незаконченное высшее (3 курса ВУЗа)", question));
        answerService.saveAnswer(new Answer("среднее специальное (техникум, колледж, ПУ)", question));
        answerService.saveAnswer(new Answer("среднее общее (10/11 классов)", question));
        answerService.saveAnswer(new Answer("неполное среднее (8/9 классов)", question));
        answerService.saveAnswer(new Answer("начальное образование (1-4 классов)", question));
        answerService.saveAnswer(new Answer("не имеет начального образования", question));

        question = questionService.questionSave(new Question("Перечислите источники средств к существованию Вашей семьи в среднем на 1 месяц:", "checkType"));
        answerService.saveAnswer(new Answer("заработная плата", question));
        answerService.saveAnswer(new Answer("доход от предпринимательской деятельности", question));
        answerService.saveAnswer(new Answer("доходы от продажи продуктов с ЛПХ, собранных грибов, ягод, продуктов охоты, рыболовства", question));
        answerService.saveAnswer(new Answer("доход от сдачи собственности в аренду", question));
        answerService.saveAnswer(new Answer("пенсия всех видов", question));
        answerService.saveAnswer(new Answer("пособие по безработице", question));
        answerService.saveAnswer(new Answer("алименты", question));
        answerService.saveAnswer(new Answer("стипендии", question));
        answerService.saveAnswer(new Answer("налоговые вычеты (имущественные, социальные, стандартные)", question));
        answerService.saveAnswer(new Answer("пособия на детей и другие денежные субсидии (ЖКХ), компенсации(род.плата), льготы (проезд)", question));
        answerService.saveAnswer(new Answer("страховые возмещения (пособия по временной нетрудоспособности)", question));
        answerService.saveAnswer(new Answer("деньги, подарки, вещи от родственников, других частных лиц", question));
        answerService.saveAnswer(new Answer("помощь благотворительных фондов", question));
        answerService.saveAnswer(new Answer("выигрыши в лотореи и прочие игры", question));

        questionService.questionSave(new Question("Сколько составляет общий доход  ВСЕХ членов Вашей семьи в месяц (в рублях)?", "textType"));

        question = questionService.questionSave(new Question("Перечислите основные ежемесячные расходы Вашей семьи (основные траты):", "textType"));
        answerService.saveAnswer(new Answer("питание", question));
        answerService.saveAnswer(new Answer("оплата жилья и коммунальных услуг", question));
        answerService.saveAnswer(new Answer("оплата за сад, обучение, секции", question));
        answerService.saveAnswer(new Answer("приобретение одежды, обуви", question));
        answerService.saveAnswer(new Answer("приобретение лекарств, оплата лечения, анализов", question));
        answerService.saveAnswer(new Answer("приобретение мебели", question));
        answerService.saveAnswer(new Answer("содержание личного транспорта", question));
        answerService.saveAnswer(new Answer("оплата кредита, займа, ссуды", question));
        answerService.saveAnswer(new Answer("развлечения: театр, кино, прогулки и пр.", question));
        answerService.saveAnswer(new Answer("ведения ЛПХ (приобретение удобрений, кормов, с/х инвентаря, семян и пр.", question));

        questionService.questionSave(new Question("Общий расход ВСЕХ членов Вашей семьи в месяц (в рублях)?", "textType"));

        question = questionService.questionSave(new Question("Для чего Вам приходилось одалживать:", "checkType"));
        answerService.saveAnswer(new Answer("на самые необходимые расходы: еда, оплата жилья и коммунальных услуг, лекарства", question));
        answerService.saveAnswer(new Answer("покупка необходимой одежды и обуви", question));
        answerService.saveAnswer(new Answer("приобретение самых необходимых лекарств и медикаментов, оплату экстренной медпомощи", question));
        answerService.saveAnswer(new Answer("по другим причинам (указать, каким)", question));
        answerService.saveAnswer(new Answer("не одалживаю денег ни у кого", question));

        question = questionService.questionSave(new Question("Откладывают ли сбережения в вашей семье?", "radioType"));
        answerService.saveAnswer(new Answer("да, ежемесячно", question));
        answerService.saveAnswer(new Answer("от случая к случаю", question));
        answerService.saveAnswer(new Answer("нет, не хватает денег даже на текущие расходы", question));

        question = questionService.questionSave(new Question("В течение какого периода времени Ваша семья живет в стесненных материальных условиях?", "radioType"));
        answerService.saveAnswer(new Answer("менее года", question));
        answerService.saveAnswer(new Answer("от года до 2 лет", question));
        answerService.saveAnswer(new Answer("от 3 до 5 лет", question));
        answerService.saveAnswer(new Answer("от 6 до 10 лет", question));
        answerService.saveAnswer(new Answer("более 10 лет", question));

        question = questionService.questionSave(new Question("Ограничивает ли Ваша семья потребление продуктов питания?", "radioType"));
        answerService.saveAnswer(new Answer("не ограничиваем", question));
        answerService.saveAnswer(new Answer("ограничиваем иногда из-за нехватки денег", question));
        answerService.saveAnswer(new Answer("ограничиваем всегда, живем в режиме жесткой экономии", question));

        question = questionService.questionSave(new Question("Какова причина того, что Ваша семья имеет доходы ниже величины прожиточного минимума? (Справка: ВПМ на 3 кв. 2018 г. на душу населения - 10032 руб. в месяц)", "checkType"));
        answerService.saveAnswer(new Answer("низкий уровень оплаты труда", question));
        answerService.saveAnswer(new Answer("отсутствие работы (подработки) по месту жительства", question));
        answerService.saveAnswer(new Answer("ухаживаю за больным членом семьи", question));
        answerService.saveAnswer(new Answer("много несовершеннолетних в семье", question));
        answerService.saveAnswer(new Answer("не позволяет работать состояние здоровья", question));
        answerService.saveAnswer(new Answer("высокие цены на продукты питания и вещи", question));
        answerService.saveAnswer(new Answer("отсутствие точек сбыта для реализации продукции с ЛПХ", question));
        answerService.saveAnswer(new Answer("невысокий размер социальных выплат и пособий", question));

        question = questionService.questionSave(new Question("Что из ниже перечисленного Вы предпринимали для того, чтобы изменить материальное благосостояние своей семьи?", "checkType"));
        answerService.saveAnswer(new Answer("поменять место работы", question));
        answerService.saveAnswer(new Answer("переехать в другой регион", question));
        answerService.saveAnswer(new Answer("поменять профессию", question));
        answerService.saveAnswer(new Answer("обратиться к родственникам за помощью", question));
        answerService.saveAnswer(new Answer("повысить свой образовательный уровень (получить второе образование)", question));
        answerService.saveAnswer(new Answer("ввести ЛПХ (растеневодство или животноводство для продажи продукции)", question));
        answerService.saveAnswer(new Answer("найти нерегулярные заработки, подработку", question));
        answerService.saveAnswer(new Answer("продать неиспользуемое имущество", question));
        answerService.saveAnswer(new Answer("открыть собственное дело", question));
        answerService.saveAnswer(new Answer("экономить на развлечениях и отдыхе", question));
        answerService.saveAnswer(new Answer("сдавать в аренду имущество", question));
        answerService.saveAnswer(new Answer("экономить на покупке одежды и обуви", question));
        answerService.saveAnswer(new Answer("обраться в государственные органы или органы местного самоуправления за материальной помощью", question));
        answerService.saveAnswer(new Answer("экономить на питании", question));
        answerService.saveAnswer(new Answer("взять кредит, ссуду, заем", question));

        question = questionService.questionSave(new Question("Как Вы оцениваете значение личного подсобного хозяйства для бюджета Вашей семьи?", "radioType"));
        answerService.saveAnswer(new Answer("не имеем ЛПХ: по состоянию здоровья не сможем обрабатывать, далеко добираться, нет возможности купить, нет желания заниматься землей", question));
        answerService.saveAnswer(new Answer("это основной источник питания для нашей семьи", question));
        answerService.saveAnswer(new Answer("дополнительный источник питания и денежных доходов от продажи продукции", question));
        answerService.saveAnswer(new Answer("никакого значения не имеет", question));

        question = questionService.questionSave(new Question("При наличии ЛПХ - укажите сферу деятельности:", "radioType"));
        answerService.saveAnswer(new Answer("растениеводство", question));
        answerService.saveAnswer(new Answer("животноводство", question));
        answerService.saveAnswer(new Answer("смешанное хозяйство", question));

        question = questionService.questionSave(new Question("Имеются ли у Вашей семьи сельскохозяйственные животные, укажите количество:", "textType"));
        answerService.saveAnswer(new Answer("КРС", question));
        answerService.saveAnswer(new Answer("МРС", question));
        answerService.saveAnswer(new Answer("лошади", question));
        answerService.saveAnswer(new Answer("свиньи", question));
        answerService.saveAnswer(new Answer("куры", question));

        question = questionService.questionSave(new Question("Где проживает Ваша семья?", "radioType"));
        answerService.saveAnswer(new Answer("отдельная благоустроенная квартира (многоквартирный дом)", question));
        answerService.saveAnswer(new Answer("неблагоустроенная квартира (с частичными удобствами)", question));
        answerService.saveAnswer(new Answer("индивидуальный построенный дом", question));
        answerService.saveAnswer(new Answer("дом с частичными удобствами", question));
        answerService.saveAnswer(new Answer("съемное жилье", question));
        answerService.saveAnswer(new Answer("жилплощадь в общежитии", question));
        answerService.saveAnswer(new Answer("часть квартиры (дома), где живут родственники", question));

        question = questionService.questionSave(new Question("Есть ли перед Вашей семьей остро стоит жилищный вопрос, как Вы его решаете?", "checkType"));
        answerService.saveAnswer(new Answer("такой вопрос не стоит", question));
        answerService.saveAnswer(new Answer("занимаетесь обменом, куплей-продажей", question));
        answerService.saveAnswer(new Answer("собираетесь приобрести еще 1 жилье", question));
        answerService.saveAnswer(new Answer("делаете пристройку, перепланировку", question));
        answerService.saveAnswer(new Answer("стоите в очереди", question));
        answerService.saveAnswer(new Answer("переедете туда, где есть более дешевое жилье", question));
        answerService.saveAnswer(new Answer("рассчитываете получить наследство", question));
        answerService.saveAnswer(new Answer("никак не решаете из-за отсутствия денег", question));
        answerService.saveAnswer(new Answer("получение кредита (ипотеки)", question));

        question = questionService.questionSave(new Question("Имеет ли Ваша семья (кто-нибудь из членов Вашей семьи) еще одно жилье:", "checkType"));
        answerService.saveAnswer(new Answer("отдельная квартира", question));
        answerService.saveAnswer(new Answer("индивидуальный дом", question));
        answerService.saveAnswer(new Answer("комната (несколько комнат) в общежитии (квартире)", question));
        answerService.saveAnswer(new Answer("дача/коллективный огород", question));
        answerService.saveAnswer(new Answer("гараж стационарный/бокс", question));
        answerService.saveAnswer(new Answer("земельный участок", question));

        question = questionService.questionSave(new Question("Имеются ли в распоряжении Вашей семьи транспортные средства, укажите их количество:", "textType"));
        answerService.saveAnswer(new Answer("ничего не имеем", question));
        answerService.saveAnswer(new Answer("легковой автомобиль", question));
        answerService.saveAnswer(new Answer("автобус/ микроавтобус", question));
        answerService.saveAnswer(new Answer("грузовой автомобиль", question));
        answerService.saveAnswer(new Answer("спецтехника", question));

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
        answerService.saveAnswer(new Answer("образование, наука", question));
        answerService.saveAnswer(new Answer("сельское хозяйство", question));
        answerService.saveAnswer(new Answer("финансы,кредит, страхование", question));
        answerService.saveAnswer(new Answer("здравоохранение", question));
        answerService.saveAnswer(new Answer("социальная защита", question));
        answerService.saveAnswer(new Answer("сфера услуг", question));

        question = questionService.questionSave(new Question("К какой группе работников относятся члены Вашей семьи?", "radioType"));
        answerService.saveAnswer(new Answer("руководитель", question));
        answerService.saveAnswer(new Answer("начальник", question));
        answerService.saveAnswer(new Answer("специалист", question));
        answerService.saveAnswer(new Answer("служащий технического и обслуживающего персонала (повар, няня, разнорабочий и т.п.", question));
        answerService.saveAnswer(new Answer("военнослужащий", question));

        question = questionService.questionSave(new Question("Что предпринимали члены вашей семьи  для поиска работы?", "checkType"));
        answerService.saveAnswer(new Answer("работу не искал(а)", question));
        answerService.saveAnswer(new Answer("обращался(ась) к друзьям, родным, знакомым", question));
        answerService.saveAnswer(new Answer("встал(а) на учет в службу занятости", question));
        answerService.saveAnswer(new Answer("обращался(ась) непосредственно на предприятие, к работодателю", question));
        answerService.saveAnswer(new Answer("пытался(ась) организовать собственное дело", question));
        answerService.saveAnswer(new Answer("слежу за информацией о вакансиях по объявлениям  в газете, по радио, в интернете", question));

        question = questionService.questionSave(new Question("Как Вы оцените здоровье членов Вашей семьи?", "radioType"));
        answerService.saveAnswer(new Answer("в основном здоровы", question));
        answerService.saveAnswer(new Answer("в семье имеются инвалид(ы)", question));
        answerService.saveAnswer(new Answer("часто болеют дети", question));
        answerService.saveAnswer(new Answer("болеют редко", question));
        answerService.saveAnswer(new Answer("имеются больные с хроническими заболеваниями", question));

        question = questionService.questionSave(new Question("За последний год обращался ли кто-либо из членов Вашей семьи за медпомощью к платным врачам?", "radioType"));
        answerService.saveAnswer(new Answer("не было необходимости", question));
        answerService.saveAnswer(new Answer("да, так как нет бесплатных врачей такого профиля", question));
        answerService.saveAnswer(new Answer("к бесплатному невозможно попасть", question));
        answerService.saveAnswer(new Answer("не устроил прием бесплатного врача", question));

        question = questionService.questionSave(new Question("Если в семье есть хронические больные/инвалиды, то обеспечиваются ли они необходимыми  лекарствами?", "radioType"));
        answerService.saveAnswer(new Answer("да, полностью, регулярно", question));
        answerService.saveAnswer(new Answer("нерегулярно, так как вынуждены экономить на этом", question));
        answerService.saveAnswer(new Answer("нет, на это нет денег", question));
        answerService.saveAnswer(new Answer("хронических больных нет", question));

        question = questionService.questionSave(new Question("Получает ли кто-либо из членов Вашей семьи какие-либо меры соц. поддержки?", "checkType"));
        answerService.saveAnswer(new Answer("Одно село - один продукт", question));
        answerService.saveAnswer(new Answer("Кыштаг для молодой семьи", question));
        answerService.saveAnswer(new Answer("Корова-кормилица", question));
        answerService.saveAnswer(new Answer("Социальный уголь", question));
        answerService.saveAnswer(new Answer("Социальный картофель", question));
        answerService.saveAnswer(new Answer("В каждой семье не менее одного ребенка с высшим образованием", question));

        question = questionService.questionSave(new Question("Получала ли Ваша семья (кто-либо из членов Вашей семьи) помощь от отдельно живущих родителей, родственников, соседей, незнакомых людей (организация)?", "checkType"));
        answerService.saveAnswer(new Answer("регулярно деньгами", question));
        answerService.saveAnswer(new Answer("регулярно продуктами, вещами", question));
        answerService.saveAnswer(new Answer("помогли в получении (погашеннии) кредита/ипотеки", question));
        answerService.saveAnswer(new Answer("единовременно (при покупке жилья/техники/ оплата ", question));
        answerService.saveAnswer(new Answer("оказали помошь в трудоустройстве", question));
        answerService.saveAnswer(new Answer("материальной помошь не получали", question));
        answerService.saveAnswer(new Answer("помогают растить ребенка/ухаживать за членом семьи", question));

        question = questionService.questionSave(new Question("Если получали, какую роль играет эта помощь в бюджете Вашей семьи?", "radioType"));
        answerService.saveAnswer(new Answer("без этого не смогли бы прожить", question));
        answerService.saveAnswer(new Answer("существенно", question));
        answerService.saveAnswer(new Answer("незначительно", question));
        answerService.saveAnswer(new Answer("никакой роли, просто традиция", question));

        question = questionService.questionSave(new Question("Случались ли в Вашей семье за последний год непредвиденные радостные (рождение ребенка и пр.) или печальные (похороны, операция и др.) события?", "radioType"));
        answerService.saveAnswer(new Answer("радостные", question));
        answerService.saveAnswer(new Answer("печальные", question));
        answerService.saveAnswer(new Answer("событий не было", question));

        question = questionService.questionSave(new Question("Укажите источники средств, которые Вы использовали на вышеуказанные события:", "checkType"));
        answerService.saveAnswer(new Answer("обошлись собственными силами", question));
        answerService.saveAnswer(new Answer("получили государственное пособие", question));
        answerService.saveAnswer(new Answer("получили помощь друзей/родственников", question));
        answerService.saveAnswer(new Answer("помощь предприятия", question));
        answerService.saveAnswer(new Answer("взяли в долг", question));

        question = questionService.questionSave(new Question("Как Вы считаете, что можно изменить в Вашем населенном пункте, чтобы преодолеть бедность вообще или повысить материальный достаток Вашей семьи?", "checkType"));
        answerService.saveAnswer(new Answer("рабочие места", question));
        answerService.saveAnswer(new Answer("строительство новых предприятий (школы, садиков и т.п.)", question));
        answerService.saveAnswer(new Answer("изменение критериев социальных проектов (возраст, состав семьи и т.п.)", question));
        answerService.saveAnswer(new Answer("регулирование цен на продукты", question));
        answerService.saveAnswer(new Answer("реконструкция/строительство дорог(мостов)", question));
        answerService.saveAnswer(new Answer("заниматься животноводством/растениеводством", question));
        answerService.saveAnswer(new Answer("доступные кредитные ресурсы", question));
    }
}
