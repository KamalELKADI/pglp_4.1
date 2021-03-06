package fr.uvsq.pglp_4_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import fr.uvsq.pglp_4_1.builder.composite.iterator.ParGroupeIterator;
import fr.uvsq.pglp_4_1.builder.composite.iterator.ParHierarchieIterator;
import fr.uvsq.pglp_4_1.builder.composite.iterator.Personnel;
import fr.uvsq.pglp_4_1.builder.composite.iterator.Personnel.PersonnelBuilder;
import fr.uvsq.pglp_4_1.builder.composite.iterator.PersonnelGroupe;
import fr.uvsq.pglp_4_1.builder.composite.iterator.PersonnelTypeIterator;



public class PersonnelTypeIteratorTest {
	private PersonnelGroupe racine;
	
	@Before()
	public void setUp() {
		racine = new PersonnelGroupe();	
	}	
	
	@Test()
	public void testGetRacineParGroupe() {
		PersonnelTypeIterator pti = racine.parGroupeIterator();
		assertEquals(pti.getRacine(), racine);
	}
	
	@Test()
	public void testIsEmptyParGroupe() {
		PersonnelTypeIterator pti = new ParGroupeIterator(racine);
		assertFalse(pti.hasNext());
	}
	
	@Test()
	public void testPersonnelGroupeParGroupe() {
		PersonnelGroupe pg = new PersonnelGroupe();
		racine.addPersonnel(pg);
		PersonnelTypeIterator pti = new ParGroupeIterator(racine);
		assertEquals(pti.next(), pg);
	}

	@Test()
	public void testPersonnelParGroupe() {
		Personnel pg = new PersonnelBuilder("EL KADI","Kamal","Etudiant").build();
		racine.addPersonnel(pg);
		PersonnelTypeIterator pti = new ParGroupeIterator(racine);
		assertEquals(pti.next(), pg);
	}
	
	@Test()
	public void testGetRacineParHierarchie() {
		PersonnelTypeIterator pti = racine.parHierarchieIterator();
		assertEquals(pti.getRacine(), racine);
	}
	
	@Test()
	public void testIsEmptyParHierarchie() {
		PersonnelTypeIterator pti = new ParHierarchieIterator(racine);
		assertFalse(pti.hasNext());
	}

	@Test()
	public void testPersonnelGroupeParHierarchie() {
		PersonnelGroupe pg = new PersonnelGroupe();
		racine.addPersonnel(pg);
		PersonnelTypeIterator pti = new ParHierarchieIterator(racine);
		assertEquals(pti.next(), pg);
	}
	
	@Test()
	public void testPersonnelParHierarchie() {
		Personnel pg = new PersonnelBuilder("EL KADI","Kamal","Etudiant").build();
		racine.addPersonnel(pg);
		PersonnelTypeIterator pti = new ParHierarchieIterator(racine);
		assertEquals(pti.next(), pg);
	}
	
	@Test()
	public void testPersonnelList() {
		PersonnelGroupe pg = new PersonnelGroupe();
		racine.addPersonnel(pg);
		racine.removePersonnel(pg);
		assertFalse(pg.parGroupeIterator().hasNext());
	}

}
