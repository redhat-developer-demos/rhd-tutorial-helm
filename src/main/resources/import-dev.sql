insert
into
    question
(region, text, title, id)
values
    ('BeNeLux', 'Are you there?', 'Existence', nextval('question_sequence'));

insert
into
    question
(region, text, title, id)
values
    ('CEE', 'Why do we dream?', 'Existence', nextval('question_sequence'));

insert
into
    answer
(text, question_id,  id)
values
    ('Yes I am', currval('question_sequence') , nextval('answer_sequence'));

insert
into
    answer
(text, question_id,  id)
values
    ('To update our brains', currval('question_sequence') , nextval('answer_sequence'));