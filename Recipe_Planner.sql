drop table ingredients cascade constraints;
drop table recipes cascade constraints;
drop table make cascade constraints;
drop table partOf cascade constraints;

create table ingredients (
ingredName varchar2(10) primary key,
category varchar2(20),
nutritionFacts varchar2(40),
inStock char(1) default 't'
);

create table recipes (
recipeName varchar2(20) primary key,
instructions varchar2(1000),
category varchar2(10)
);

create table make (
ingredName varchar2(10) references ingredients(ingredName),
recipeName varchar2(20) references recipes(recipeName) on delete cascade
);

create table partOf (
planDate varchar2(10),
mealTime varchar2(10),
recipeName varchar2(20) references recipes(recipeName)
);

insert into ingredients values ('chicken', 'meat', 'high in protien', 't');
insert into ingredients values ('flour', 'grain', 'majority carbs', 'f');
insert into ingredients values ('chocolate', 'sweets', 'mainly sugar', 'f');
insert into ingredients values ('milk', 'dairy', 'has calcium', 't');
insert into ingredients values ('butter', 'dairy', 'sodium and fat', 'f');
insert into ingredients values ('cheese', 'dairy', 'fat and cholesterol', 't');


insert into recipes values ('Chocolate Cake', 'Preheat oven to 350 degrees.
Butter three 9-inch cake rounds. Dust with flour and tap out the excess. (see cooking lesson below)
Mix together flour, sugar, cocoa, baking soda, baking powder, and salt in a stand mixer using a low speed until combined.
Add eggs, buttermilk, warm water, oil, and vanilla. Beat on a medium speed until smooth. This should take just a couple of minutes.
Divide batter among the three pans. I found that it took just over 3 cups of the batter to divide it evenly.
Bake for 30-35 minutes until the cake meets the toothpick test (stick a toothpick in and it comes out clean).', 'dessert');
insert into recipes values ('Mac and Cheese', 'Preheat oven to 350 degrees F (175 degrees C). Bring a large pot of lightly 
salted water to a boil, add pasta, and cook until done; drain. In 9x13 inch baking dish, stir together macaroni, shredded Cheddar cheese, cottage cheese, sour cream, Parmesan cheese, salt and pepper. 
In a small bowl, mix together bread crumbs and melted butter. Sprinkle topping over macaroni mixture.Bake 30 to 35 minutes, or until top is golden', 'side dish');
insert into recipes values('Cheddar Buscuits', 'Preheat oven to 400 degrees F (205 degrees C). Grease a cookie sheet, or line with parchment paper.
In a large bowl, combine baking mix, Cheddar cheese, and garlic powder. Stir in milk. Drop batter by heaping tablespoonfuls onto prepared cookie sheet.
Bake in preheated oven for 10 minutes. Brush biscuits with melted margarine, and sprinkle with parsley and garlic salt. Bake for 5 more minutes, or until lightly browned on the bottom.','side dish');

insert into make values('flour', 'Chocolate Cake');
insert into make values('chocolate', 'Chocolate Cake');
insert into make values ('cheese', 'Mac and Cheese');
insert into make values('milk', 'Mac and Cheese');
insert into make values('milk', 'Chocolate Cake');
insert into make values('butter', 'Mac and Cheese');
insert into make values('butter', 'Cheddar Buscuits');
insert into make values('milk', 'Cheddar Buscuits');
insert into make values('flour', 'Cheddar Buscuits');
insert into make values('cheese', 'Cheddar Buscuits');


insert into partOf values('2017-04-27', 'dessert','Chocolate Cake');
insert into partOf values('2017-04-28', 'lunch','Mac and Cheese');
insert into partOf values('2017-04-28', 'dinner','Pasta');
insert into partOf values('2017-04-28', 'lunch','Chieck Curry');
insert into partOf values('2017-04-28', 'dinner','lo mien');
insert into partOf values('2017-04-28', 'lunch','fish and chips');
insert into partOf values('2017-04-28', 'Breakfast','Eggs and Bacon');
insert into partOf values('2017-04-28', 'Breakfast','oatMeal');

select * from ingredients;
select * from recipes;
select * from make;
select * from partOf;

commit;