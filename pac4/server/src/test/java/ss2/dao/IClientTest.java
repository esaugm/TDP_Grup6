/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2.dao;

import java.util.ArrayList;
import junit.framework.TestCase;
import ss2.entity.Client;
import ss2.exception.AppException;

/**
 *
 * @author josi
 */
public class IClientTest extends TestCase {

		public IClientTest(String testName) {
				super(testName);
		}

		@Override
		protected void setUp() throws Exception {
				super.setUp();
		}

		@Override
		protected void tearDown() throws Exception {
				super.tearDown();
		}

		/**
		 * Test of checkAndInitDAO method, of class IClient.
		 */
		public void testCheckAndInitDAO() throws Exception {
				System.out.println("checkAndInitDAO");
				IClient instance = new IClientImpl();
				instance.checkAndInitDAO();
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of getClient method, of class IClient.
		 */
		public void testGetClient() throws Exception {
				System.out.println("getClient");
				IClient instance = new IClientImpl();
				ArrayList expResult = null;
				ArrayList result = instance.getClient();
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of getClientbyPK method, of class IClient.
		 */
		public void testGetClientbyPK() throws Exception {
				System.out.println("getClientbyPK");
				String nif = "";
				IClient instance = new IClientImpl();
				ArrayList expResult = null;
				ArrayList result = instance.getClientbyPK(nif);
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of getClientbyNumClient method, of class IClient.
		 */
		public void testGetClientbyNumClient() throws Exception {
				System.out.println("getClientbyNumClient");
				Integer numclient = null;
				IClient instance = new IClientImpl();
				Client expResult = null;
				Client result = instance.getClientbyNumClient(numclient);
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of getClientbyANY method, of class IClient.
		 */
		public void testGetClientbyANY() throws Exception {
				System.out.println("getClientbyANY");
				String freetext = "";
				IClient instance = new IClientImpl();
				ArrayList expResult = null;
				ArrayList result = instance.getClientbyANY(freetext);
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of createClient method, of class IClient.
		 */
		public void testCreateClient() throws Exception {
				System.out.println("createClient");
				Client cliente = null;
				IClient instance = new IClientImpl();
				Boolean expResult = null;
				Boolean result = instance.createClient(cliente);
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of modifyClient method, of class IClient.
		 */
		public void testModifyClient() throws Exception {
				System.out.println("modifyClient");
				Client cliente = null;
				IClient instance = new IClientImpl();
				Boolean expResult = null;
				Boolean result = instance.modifyClient(cliente);
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		/**
		 * Test of deleteClient method, of class IClient.
		 */
		public void testDeleteClient() throws Exception {
				System.out.println("deleteClient");
				Client cliente = null;
				IClient instance = new IClientImpl();
				Boolean expResult = null;
				Boolean result = instance.deleteClient(cliente);
				assertEquals(expResult, result);
				// TODO review the generated test code and remove the default call to fail.
				fail("The test case is a prototype.");
		}

		public class IClientImpl implements IClient {

				public void checkAndInitDAO() throws AppException {
				}

				public ArrayList<Client> getClient() throws AppException {
						return null;
				}

				public ArrayList<Client> getClientbyPK(String nif) throws AppException {
						return null;
				}

				public Client getClientbyNumClient(Integer numclient) throws AppException {
						return null;
				}

				public ArrayList<Client> getClientbyANY(String freetext) throws AppException {
						return null;
				}

				public Boolean createClient(Client cliente) throws AppException {
						return null;
				}

				public Boolean modifyClient(Client cliente) throws AppException {
						return null;
				}

				public Boolean deleteClient(Client cliente) throws AppException {
						return null;
				}
		}
}
