package com.tutorials.quizapp

object Constants {

    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val que1 = Question(1, "Question 1",
        R.drawable.ic_image1, "Lion", "Elephant", "Cheetah", "Tiger", 4)

        questionList.add(que1)

        val que2 = Question(2, "Question 2",
            R.drawable.ic_image2, "Deer", "Wolf", "Fox", "Leopard", 2)

        questionList.add(que2)

        val que3 = Question(3, "Question 3",
            R.drawable.ic_image3, "Giraffe", "Zebra", "Monkey", "Kangaroo", 1)

        questionList.add(que3)

        val que4 = Question(4, "Question 4",
            R.drawable.ic_image4, "Rhino", "Dog", "Lion", "Bear", 3)

        questionList.add(que4)

        val que5 = Question(5, "Question 5",
            R.drawable.ic_image5, "Panther", "Donkey", "Mule", "Horse", 4)

        questionList.add(que5)

        val que6 = Question(6, "Question 6",
            R.drawable.ic_image6, "Elephant", "Seal", "Tortoise", "Gorilla", 1)

        questionList.add(que6)

        val que7 = Question(7, "Question 7",
            R.drawable.ic_image7, "Rat", "Rabbit", "Squirrel", "Hamster", 3)

        questionList.add(que7)

        val que8 = Question(8, "Question 8",
            R.drawable.ic_image8,"Monkey", "Human", "Gorilla", "Chimpanzee", 4)

        questionList.add(que8)

        val que9 = Question(9, "Question 9",
            R.drawable.ic_image9, "Lizard", "Dragonfly", "Rhino", "Chameleon", 4)

        questionList.add(que9)

        val que10 = Question(10, "Question 10",
            R.drawable.ic_image10, "Turtle", "Tortoise", "Squid", "Shark", 1)

        questionList.add(que10)

        return questionList
    }
}