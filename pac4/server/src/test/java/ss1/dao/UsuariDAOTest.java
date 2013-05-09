package ss1.dao;

import common.entity.PerfilUsuari;
import ss1.dao.exception.ExceptionErrorDataBase;
import ss1.dao.exception.ExceptionTipoObjetoFiltroNoPermitido;
import ss1.dao.impl.UsuariDAO;
import ss1.entity.Usuari;
import ss1.service.filter.FilterItems;

import java.util.List;

/**
 * TDP Grup6
 * User: Esaú González
 * Date: 5/05/13
 * Time: 17:27
 */
public class UsuariDAOTest {
    public static void main(String[] args){
        IUsuariDAO usuariDAO = new UsuariDAO();
        
        prepareEnvironmentForTest(usuariDAO);
        
        testFindAllUsuari(usuariDAO);

        testFindUsuariByPK(usuariDAO);
        
        testFindUsuariByUsuariLogin(usuariDAO);
        
        testAltaUsuari(usuariDAO);
        
        testBaixaUsuari(usuariDAO);
        
        testModificacioUsuari(usuariDAO);
        
        testFindUsuariByFilter(usuariDAO);


    }

    private static void testFindUsuariByFilter(IUsuariDAO usuariDAO) {
        //solo filtramos por taller (Integer), usuari (String) y perfil (PerfilUsuari)
        System.out.println("Filtro por usuario pepelui1");
        FilterItems filterItemUsuari = new FilterItems();
        filterItemUsuari.addFilterValue("usuari", "pepelui1");
        getUsuarisByFilterAndPrintLog(filterItemUsuari, usuariDAO);

        System.out.println("Filtro por taller 2");
        FilterItems filterItemTaller = new FilterItems();
        filterItemTaller.addFilterValue("taller", 2);
        getUsuarisByFilterAndPrintLog(filterItemTaller,usuariDAO);

        System.out.println("Filtro por perfil ADMINISTRATIU");
        FilterItems filterItemPerfil = new FilterItems();
        filterItemPerfil.addFilterValue("perfil", PerfilUsuari.ADMINISTRATIU );
        getUsuarisByFilterAndPrintLog(filterItemPerfil,usuariDAO);

        System.out.println("Filtro por usuario testModif, taller 2");
        FilterItems filterItemUsuariTaller = new FilterItems();
        filterItemUsuariTaller.addFilterValue("usuari", "testModif");
        filterItemUsuariTaller.addFilterValue("taller", 2);
        getUsuarisByFilterAndPrintLog(filterItemUsuariTaller, usuariDAO);

        System.out.println("Filtro por usuario pepelui1, perfil ADMINISTRATIU");
        FilterItems filterItemUsuariPerfil = new FilterItems();
        filterItemUsuariPerfil.addFilterValue("usuari", "pepelui1");
        filterItemUsuariPerfil.addFilterValue("perfil", PerfilUsuari.ADMINISTRATIU);
        getUsuarisByFilterAndPrintLog(filterItemUsuariPerfil, usuariDAO);

        System.out.println("Filtro por taller 2, perfil CAPTALLER");
        FilterItems filterItemTallerPerfil = new FilterItems();
        filterItemTallerPerfil.addFilterValue("taller", 2);
        filterItemTallerPerfil.addFilterValue("perfil", PerfilUsuari.CAPTALLER);
        getUsuarisByFilterAndPrintLog(filterItemTallerPerfil,usuariDAO);

        System.out.println("Filtro por usuario testModif, taller 2, perfil CAPTALLER");
        FilterItems filterItemUsuariTallerPerfil = new FilterItems();
        filterItemUsuariTallerPerfil.addFilterValue("usuari", "testModif");
        filterItemUsuariTallerPerfil.addFilterValue("taller", 2);
        filterItemUsuariTallerPerfil.addFilterValue("perfil", PerfilUsuari.CAPTALLER);
        getUsuarisByFilterAndPrintLog(filterItemUsuariTallerPerfil, usuariDAO);

        System.out.println("Intento de filtro sin filtro");
        FilterItems filterItemEmpty = new FilterItems();
        getUsuarisByFilterAndPrintLog(filterItemEmpty,usuariDAO);

        System.out.println("Intento de filtro con datos no existentes: usuario cabesa");
        FilterItems filterItemUsuariNoExistente = new FilterItems();
        filterItemUsuariNoExistente.addFilterValue("usuari", "cabesa");
        getUsuarisByFilterAndPrintLog(filterItemUsuariNoExistente, usuariDAO);

        System.out.println("Intento de filtro con datos no existentes:  taller 1, perfil ADMINISTRATIU");
        FilterItems filterItemTallerPerfilNoExiste = new FilterItems();
        filterItemTallerPerfilNoExiste.addFilterValue("taller", 1);
        filterItemTallerPerfilNoExiste.addFilterValue("perfil", PerfilUsuari.ADMINISTRATIU);
        getUsuarisByFilterAndPrintLog(filterItemTallerPerfilNoExiste,usuariDAO);

        System.out.println("Intento de filtro con datos no existentes: usuario test1, taller 3, perfil ");
        FilterItems filterItemUsuariTallerPerfilNoExiste = new FilterItems();
        filterItemUsuariTallerPerfilNoExiste.addFilterValue("usuari", "test1");
        filterItemUsuariTallerPerfilNoExiste.addFilterValue("taller", 3);
        filterItemUsuariTallerPerfilNoExiste.addFilterValue("perfil", PerfilUsuari.MECANIC);
        getUsuarisByFilterAndPrintLog(filterItemUsuariTallerPerfilNoExiste, usuariDAO);
        
        
    }

    private static void getUsuarisByFilterAndPrintLog(FilterItems filterItems, IUsuariDAO usuariDAO) {
        try {
            List<Usuari> usuaris = usuariDAO.findUsuariByFilter(filterItems);
            for (Usuari usuari : usuaris) {
                System.out.println(usuari.getUsuari());
            }
        } catch (ExceptionTipoObjetoFiltroNoPermitido exceptionTipoObjetoFiltroNoPermitido) {
            exceptionTipoObjetoFiltroNoPermitido.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private static void testFindAllUsuari(IUsuariDAO usuariDAO) {
        try {
            List<Usuari> usuaris = usuariDAO.findAll();
            for (Usuari usuari : usuaris) {
                System.out.println(usuari.getUsuari());
            }
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();
        }
    }

    private static void prepareEnvironmentForTest(IUsuariDAO usuariDAO) {
        try {
            Usuari toDelete = usuariDAO.findByUsuariLogin("test1");
            if (toDelete!=null) usuariDAO.deleteUsuari(toDelete);

            toDelete = usuariDAO.findByUsuariLogin("test2");
            if (toDelete!=null) usuariDAO.deleteUsuari(toDelete);
            
            toDelete = usuariDAO.findByUsuariLogin("testModif");
            if (toDelete!=null) usuariDAO.deleteUsuari(toDelete);
            
            
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();
        }
    }

    private static void testAltaUsuari(IUsuariDAO usuariDAO) {
        Usuari usuariNou = new Usuari();
        usuariNou.setTaller(1);
        usuariNou.setUsuari("test1");
        usuariNou.setPerfil(PerfilUsuari.ADMINISTRADOR);
        usuariNou.setContrasenya("12345");
        //usuariNou.setActiu(true); TODO by default
        //usuariNou.setDataAlta(); TODO by default
        //usuariNou.setReparacionsAssignades(0); TODO by default
        
        Usuari usuariNou2 = new Usuari();
        usuariNou2.setTaller(2);
        usuariNou2.setUsuari("test2");
        usuariNou2.setPerfil(PerfilUsuari.CAPTALLER);
        usuariNou2.setContrasenya("67890");

        try {
            usuariDAO.createUsuari(usuariNou);
            usuariDAO.createUsuari(usuariNou2);
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();
        }
        System.out.println("Usuari creat correctament!");
    }

    private static void testBaixaUsuari(IUsuariDAO usuariDAO) {

        try {
            Usuari usuariPerBorrar = usuariDAO.findByUsuariLogin("test1");
            usuariDAO.deleteUsuari(usuariPerBorrar);
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();
        }
        System.out.println("Usuari esborrat correctament!");
    }

    private static void testModificacioUsuari(IUsuariDAO usuariDAO) {
        Usuari usuariPerModificar = null;
        try {
            usuariPerModificar = usuariDAO.findByUsuariLogin("test2");
            
            usuariPerModificar.setUsuari("testModif");
            usuariPerModificar.setContrasenya("09876");
            
            usuariDAO.modifyUsuari(usuariPerModificar);
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();
        }

        System.out.println("USuari modificat correctament!");
    }

    private static void testFindUsuariByUsuariLogin(IUsuariDAO usuariDAO) {
        try {
            Usuari usuari = usuariDAO.findByUsuariLogin("pepelui1");
            System.out.println("Usuari con login pepelui1, password " + usuari.getContrasenya());
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();
        }
    }

    private static void testFindUsuariByPK(IUsuariDAO usuariDAO){
        try {
            Usuari usuari = usuariDAO.findByPK(1);
            System.out.println("Usuari1: " +usuari.getUsuari());

            usuari = usuariDAO.findByPK(2);
            System.out.println("Usuari2: " +usuari.getUsuari());

            usuari = usuariDAO.findByPK(3);
            System.out.println("Usuari3: " +usuari.getUsuari());

            usuari = usuariDAO.findByPK(4);
            System.out.println("Usuari4: " +usuari.getUsuari());
        } catch (ExceptionErrorDataBase exceptionErrorDataBase) {
            exceptionErrorDataBase.printStackTrace();
        }

    }
}
