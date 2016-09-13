-- Task [ent1]
alter table "public"."task"  add column  "grade_2"  int4;


-- Task_Item [rel1]
create table "public"."task_item" (
   "task_oid"  int4 not null,
   "item_oid"  int4 not null,
  primary key ("task_oid", "item_oid")
);
alter table "public"."task_item"   add constraint fk_task_item_task foreign key ("task_oid") references "public"."task" ("oid");
alter table "public"."task_item"   add constraint fk_task_item_item foreign key ("item_oid") references "public"."item" ("oid");


