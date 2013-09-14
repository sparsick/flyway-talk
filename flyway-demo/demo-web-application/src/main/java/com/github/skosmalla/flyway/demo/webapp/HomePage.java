package com.github.skosmalla.flyway.demo.webapp;

import java.util.List;

import com.github.skosmalla.flyway.demo.webapp.domain.Person;
import com.github.skosmalla.flyway.demo.webapp.repository.PersonRepository;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	@SpringBean
	private PersonRepository personRepository;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		List<Person> list = personRepository.findAllPersons();

		add(new ListView<Person>("personList", list) {

            /**  */
            private static final long serialVersionUID = 9172837350405031400L;

            @Override
            protected void populateItem(ListItem<Person> item) {
              Person person = item.getModelObject();
              item.add(new Label("firstname", person.getFirstName()));
              item.add(new Label("lastname", person.getLastName()));
            }
        });

		CompoundPropertyModel<Person> formModel = new CompoundPropertyModel<Person>(new Person());
		Form<Person> form = new Form<Person>("newPersonForm",  formModel) {


		    /**  */
            private static final long serialVersionUID = -8916183430933475415L;

            @Override
		    protected void onSubmit() {
		        super.onSubmit();
		        personRepository.save(getModelObject());
		        setResponsePage(HomePage.class);

		    }
		};
        form.add(new TextField<String>("firstName"));
        form.add(new TextField<String>("lastName"));
        form.add(new Button("submitButton"));
        add(form);




    }
}
