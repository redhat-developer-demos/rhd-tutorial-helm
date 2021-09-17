insert
into
    question
(region, text, title, id)
values
('BeNeLux', 'Are you there?', 'Existence', nextval('question_sequence'));

insert
into
    answer
(text, question_id,  id)
values
('Yes I am', currval('question_sequence') , nextval('answer_sequence'));
