import allo.*;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class TestConcours {
    @Test
    public void testNettoyerTable(){
        Concours concours = new Concours(10, 0);
        Galette galette = new Galette(0);
        Galette galetteBase = new Galette(500);
        Galette galetteLaVrai = new GalettePistache(galetteBase);
        concours.getGalettes().add(galette);
        concours.getGalettes().add(galetteLaVrai);
        concours.nettoyerTable();
        assert concours.getGalettes().size() == 1;
        assert concours.getGalettes().get(0).getPoidsGalette() == 2500;
    }

    @Test
    public void testEnleverPerdants() {
        Concours concours = new Concours(2, 2);
        concours.createConcours();
        concours.getListeMangeurs().get(0).setPoidsMange(999999999); // la il a bien mangé
        concours.enleverLesPerdants();
        assert concours.getListeMangeurs().size() == 1;
    }

    @Test
    public void testConcourirNull(){
        Concours concours = new Concours(0, 2);
        concours.createConcours();
        assertNull(concours.concourir());
    }

    @Test
    public void testConcourirGood(){
        Concours concours = new Concours(1, 1);
        concours.createConcours();
        concours.getGalettes().forEach(galette -> galette.getParts().forEach(partDeGalette -> partDeGalette.setFeve(true)));
        MangeurDeGalettes councourreur = concours.getListeMangeurs().get(0);
        assert concours.concourir().equals(councourreur);
    }

    @Test
    public void testConcourirUnSupporter() {
        Concours concours = new Concours(1, 1);

        Supporteur spySupporteur = spy(new Supporteur("test"));

        concours.createConcours();
        concours.ajouterObservateur(spySupporteur);
        concours.getGalettes().forEach(galette -> galette.getParts().forEach(partDeGalette -> partDeGalette.setFeve(false)));
        concours.concourir();

        verify(spySupporteur, times(1)).applaudit();
    }

    @Test
    public void testConcourirPlusieursSupporters() {
        Concours concours = new Concours(1, 1);

        Supporteur spySupporteur = spy(new Supporteur("test"));
        Supporteur spySupporteur2 = spy(new Supporteur("test2"));

        concours.createConcours();
        concours.ajouterObservateur(spySupporteur);
        concours.ajouterObservateur(spySupporteur2);
        concours.getGalettes().forEach(galette -> galette.getParts().forEach(partDeGalette -> partDeGalette.setFeve(false)));
        concours.concourir();

        verify(spySupporteur, times(1)).applaudit();
        verify(spySupporteur2, times(1)).applaudit();
    }

    @Test
    public void testConcourirGoodAvecSupporter(){
        Concours concours = new Concours(1, 1);
        Supporteur spySupporteur = spy(new Supporteur("test"));

        concours.createConcours();
        concours.ajouterObservateur(spySupporteur);

        concours.getGalettes().forEach(galette -> galette.getParts().forEach(partDeGalette -> partDeGalette.setFeve(true)));
        MangeurDeGalettes councourreur = concours.getListeMangeurs().get(0);

        verify(spySupporteur, times(0)).applaudit();
        assert concours.concourir().equals(councourreur);
    }
}
