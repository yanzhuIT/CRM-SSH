# CRM-SSH
Using Struts 2, Spring, Hibernate to construct a practical web application.
MVC: action--service--dao
## Working framework configuration
- web.xml: listener for loading Spring file, filter for keeping session, filter for Struts action
- struts.xml: constant for loading file size, actions and their methods
- bean.xml and others Spring .xml for modules: DataSource(c3p0), Sessionfactory, database transaction, annotation, hibernateTemplate, IOC configuration
- hibernate.cfg.xml and entities' hibernate file: SessionFactory basic properties, ORM configuration 

----
Application includes six basic functional module:
## User Login module
## Customer Management module
- paging
- query: hql and DetachedCriteria
- one-to-many configuration
- cascade delete, inverse for "no session" problem
- data dictionary table
## LinkMan Management module
- many-to-one configuration
- upload file
## Visiting Management module
- many-to-many configuration
- code review: BaseDao
## Multiple Condition Query module
- hql
- DetachedCriteria
## Statistic module
- original sql

