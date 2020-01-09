# QuizBot Project

This project is composed of a compiler with a survey grammar and a Telegram chatbot that allows to collect data from the defined surveys and consult simple graphs and reports on the collected data.

## Getting Started

You can get a copy of the project up and running on your local machine just cloning this repository.

### Prerequisites

You will need to have the NetworkX and Matplotlib libraries installed.

You can install them with our requirements.txt by terminal:

```
$ pip install -r requirements.txt
```

### Running the chatbot

Just run the bot.py file inside the project's bot folder and you can now interact with it in Telegram.

```
$ python3 bot.py
```

## Running the compiler tests

First of all, you will need to create a 'txt' file with the design of the survey to be performed or you can use our default survey 'enquesta.txt'.

Now, you just need to run the test.main.py file as follow to generate the data graph that chatbot will use:

```
$ python3 test.main.py enquesta.txt
```

## Author

* **Oriol Soler** - *GEI-LP Project* - [usoler](https://github.com/usoler)
