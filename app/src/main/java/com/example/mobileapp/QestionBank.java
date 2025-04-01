package com.example.mobileapp;

import java.util.ArrayList;
import java.util.List;

public class QestionBank {


    private static List<QuestionsList> carsQuestions(){
        final List<QuestionsList> questionsList = new ArrayList<>();
        final QuestionsList question1 = new QuestionsList("Какой двигатель внутреннего сгорания обычно используется в большинстве легковых автомобилей?",
                "Дизельный", "Газотурбинный", "Роторный", "Бензиновый", "Бензиновый", "");

        final QuestionsList question2 = new QuestionsList("Какая часть автомобиля отвечает за передачу крутящего момента от двигателя к колесам?",
                "Аккумулятор", "Трансмиссия", "Радиатор", "Генератор", "Трансмиссия", "");

        final QuestionsList question3 = new QuestionsList("Что такое ABS в автомобиле?",
                "Автоматическая блокировка сидений", "Антиблокировочная система тормозов", "Автоматическая система безопасности", "Антикоррозийное покрытие кузова", "Антиблокировочная система тормозов", "");

        final QuestionsList question4 = new QuestionsList("Какая страна является родиной компании Mercedes-Benz?",
                "США", "Япония", "Италия", "Германия", "Германия", "");

        final QuestionsList question5 = new QuestionsList("Как называется прибор, измеряющий скорость автомобиля?",
                "Тахометр", "Одометр", "Спидометр", "Манометр", "Спидометр", "");

        final QuestionsList question6 = new QuestionsList("Что такое подушка безопасности (airbag)?",
                "Элемент декора салона", "Система пассивной безопасности", "Чехол для сиденья", "Вентиляционная система", "Система пассивной безопасности", "");

        final QuestionsList question7 = new QuestionsList("Какой тип привода является наиболее распространенным в современных легковых автомобилях?",
                "Полный", "Задний", "Передний", "Гибридный", "Передний", "");

        final QuestionsList question8 = new QuestionsList("Что показывает одометр в автомобиле?",
                "Обороты двигателя", "Температуру двигателя", "Общий пробег автомобиля", "Уровень топлива", "Общий пробег автомобиля", "");

        final QuestionsList question9 = new QuestionsList("Какая компания производит автомобили марки Prius?",
                "Ford", "Toyota", "Honda", "Nissan", "Toyota", "");

        final QuestionsList question10 = new QuestionsList("Что означает термин 'лошадиная сила'?",
                "Размер двигателя", "Расход топлива", "Мощность двигателя", "Крутящий момент", "Мощность двигателя", "");

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);
        return questionsList;
    }

    private static List<QuestionsList> filmsQuestions(){
        final List<QuestionsList> questionsList = new ArrayList<>();
        final QuestionsList question1 = new QuestionsList("Кто является режиссером фильма 'Криминальное чтиво'?",
                "Квентин Тарантино", "Мартин Скорсезе", "Стивен Спилберг", "Альфред Хичкок", "Квентин Тарантино", "");

        final QuestionsList question2 = new QuestionsList("Какой фильм получил премию 'Оскар' как лучший фильм в 2020 году?",
                "Джокер", "Однажды в... Голливуде", "Паразиты", "Ирландец", "Паразиты", "");

        final QuestionsList question3 = new QuestionsList("Кто сыграл главную роль в фильме 'Бойцовский клуб'?",
                "Брэд Питт", "Леонардо Ди Каприо", "Эдвард Нортон", "Мэтт Дэймон", "Эдвард Нортон", "");

        final QuestionsList question4 = new QuestionsList("Какой фильм является первым полнометражным анимационным фильмом Disney?",
                "Золушка", "Белоснежка и семь гномов", "Спящая красавица", "Бэмби", "Белоснежка и семь гномов", "");

        final QuestionsList question5 = new QuestionsList("Кто написал музыку к фильму 'Начало' (Inception)?",
                "Ханс Циммер", "Джон Уильямс", "Эннио Морриконе", "Алан Сильвестри", "Ханс Циммер", "");

        final QuestionsList question6 = new QuestionsList("В каком году вышел фильм 'Матрица'?",
                "1995", "1999", "2003", "2007", "1999", "");

        final QuestionsList question7 = new QuestionsList("Кто сыграл роль Джеймса Бонда в фильме 'Казино Рояль' (2006)?",
                "Пирс Броснан", "Шон Коннери", "Дэниел Крейг", "Роджер Мур", "Дэниел Крейг", "");

        final QuestionsList question8 = new QuestionsList("Какой режиссер снял фильм 'Список Шиндлера'?",
                "Кристофер Нолан", "Джеймс Кэмерон", "Стивен Спилберг", "Фрэнсис Форд Коппола", "Стивен Спилберг", "");

        final QuestionsList question9 = new QuestionsList("Какой фильм рассказывает историю о создании социальной сети Facebook?",
                "Социальная сеть", "Стартап", "Хакеры", "Пираты Силиконовой долины", "Социальная сеть", "");

        final QuestionsList question10 = new QuestionsList("Кто озвучил главного героя в мультфильме 'Король Лев'?",
                "Том Хэнкс", "Мэттью Бродерик", "Джереми Айронс", "Джеймс Эрл Джонс", "Мэттью Бродерик", "");

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);
        return questionsList;
    }

    private static List<QuestionsList> cityQuestions(){
        final List<QuestionsList> questionsList = new ArrayList<>();
        final QuestionsList question1 = new QuestionsList("Какой город является столицей Франции?",
                "Рим", "Лондон", "Париж", "Берлин", "Париж", "");

        final QuestionsList question2 = new QuestionsList("В каком городе находится Колизей?",
                "Афины", "Рим", "Мадрид", "Париж", "Рим", "");

        final QuestionsList question3 = new QuestionsList("Какой город называют 'Большим яблоком'?",
                "Лос-Анджелес", "Чикаго", "Нью-Йорк", "Майами", "Нью-Йорк", "");

        final QuestionsList question4 = new QuestionsList("Какой город является самым населенным в Китае?",
                "Пекин", "Шанхай", "Гонконг", "Гуанчжоу", "Шанхай", "");

        final QuestionsList question5 = new QuestionsList("В каком городе находится знаменитая статуя Христа-Искупителя?",
                "Буэнос-Айрес", "Рио-де-Жанейро", "Сан-Паулу", "Лима", "Рио-де-Жанейро", "");

        final QuestionsList question6 = new QuestionsList("Какой город является столицей Японии?",
                "Киото", "Осака", "Токио", "Хиросима", "Токио", "");

        final QuestionsList question7 = new QuestionsList("В каком городе находится Тадж-Махал?",
                "Дели", "Мумбаи", "Агра", "Калькутта", "Агра", "");

        final QuestionsList question8 = new QuestionsList("Какой город известен своими каналами и мостами?",
                "Венеция", "Амстердам", "Брюгге", "Стокгольм", "Венеция", "");

        final QuestionsList question9 = new QuestionsList("Какой город является финансовым центром Германии?",
                "Берлин", "Мюнхен", "Гамбург", "Франкфурт", "Франкфурт", "");

        final QuestionsList question10 = new QuestionsList("Какой город считается самым большим по численности населения в мире в 2025 году?",
                "Дели", "Токио", "Мумбаи", "Дакка", "Токио", "");

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);
        return questionsList;
    }

    private static List<QuestionsList> itQuestions(){
        final List<QuestionsList> questionsList = new ArrayList<>();
        final QuestionsList question1 = new QuestionsList("Какой язык часто используют для машинного обучения?",
                "Java", "C++", "Python", "JavaScript", "Python", "");

        final QuestionsList question2 = new QuestionsList("Какой язык разработан Apple для iOS/macOS?",
                "Kotlin", "Swift", "Objective-C", "C#", "Swift", "");

        final QuestionsList question3 = new QuestionsList("Какой язык известен сборкой мусора и простотой?",
                "C", "Go", "Rust", "Java", "Java", "");

        final QuestionsList question4 = new QuestionsList("Какой язык используется для серверной разработки веб-приложений?",
                "HTML", "C#", "JavaScript", "PHP", "PHP", "");

        final QuestionsList question5 = new QuestionsList("Какой язык подчеркивает безопасность памяти и конкурентность?",
                "C++", "Rust", "Go", "Swift", "Rust", "");

        final QuestionsList question6 = new QuestionsList("Какой язык часто используется для разработки игр?",
                "C", "C++", "Java", "Python", "C++", "");

        final QuestionsList question7 = new QuestionsList("Какой язык используется для создания интерактивных веб-страниц?",
                "HTML", "JavaScript", "SQL", "PHP", "JavaScript", "");

        final QuestionsList question8 = new QuestionsList("Какой язык особенно хорош для статистического анализа?",
                "C#", "R", "JavaScript", "Swift", "R", "");

        final QuestionsList question9 = new QuestionsList("Какой язык является низкоуровневым и быстрым?",
                "Java", "C#", "C++", "Python", "C++", "");

        final QuestionsList question10 = new QuestionsList("Какой язык популярен в .NET Framework?",
                "Java", "C++", "C#", "Python", "C#", "");


        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);
        return questionsList;
    }



    public static List<QuestionsList> getQuestion (String selectedTopicName){
        switch (selectedTopicName){
            case "Автомобили" : return carsQuestions();
            case "Фильмы" : return filmsQuestions();
            case "Города" : return cityQuestions();
            default: return itQuestions();
        }
    }
}
