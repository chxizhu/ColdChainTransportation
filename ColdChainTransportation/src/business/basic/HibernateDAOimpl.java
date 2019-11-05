package business.basic;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


/*import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;*/
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateDAOimpl implements HibernateDAO {
	
	//ΪRoomDAO����һ������ʹ�õ���־����ÿ��Ҫʹ����־���඼��Ҫ�������
		//private static final Log log = LogFactory.getLog(iHibBaseDAO.class);
		
		public static final int INSERT = 1; // ������Ӳ���
		public static final int UPDATE = 2; // �����޸Ĳ���
		public static final int DELETE = 3; // ����ɾ������

		@Override
		public Object insert(Object obj) {
			Session session = HibernateSessionFactory.getSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();// ��ʼ����
				Serializable key = session.save(obj);
				tx.commit();// �ύ����ִ�ж���ĳ־û�������
				session.close();
				return key;
			} catch (Exception e) {			
				e.printStackTrace();
				if (tx != null) tx.rollback();// �ع������������ĳ־û�������
				if (session != null) session.close();
			}
			return null;
		}

		@Override
		public boolean insert(List<Object> list) {
			Session session = HibernateSessionFactory.getSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();// ��ʼ����
				for (Object obj : list) {
					session.save(obj);
				}
				tx.commit();// �ύ����ִ�ж���ĳ־û�������
				session.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) tx.rollback();// �ع������������ĳ־û�������
				if (session != null) session.close();
			}
			return false;
		}

		@Override
		public boolean delete(Class cls, Serializable id) {
			Session session = HibernateSessionFactory.getSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction(); // ����һ������
				// ����cls��id���Ҫɾ���Ķ���
				session.delete(session.get(cls, id));
				tx.commit(); // �־û�����
				session.close();
				return true;

			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) tx.rollback(); // ����
				if (session != null) session.close();
			}
			return false;
		}

		@Override
		public boolean delete(Object obj) {
			Session session = HibernateSessionFactory.getSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction(); // ����һ������
				session.delete(obj);
				tx.commit(); // �־û�����
				session.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) tx.rollback(); // ����
				if (session != null) session.close();
			}
			return false;
		}

		@Override
		public boolean update(Object obj) {
			Session session = HibernateSessionFactory.getSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction(); // ����һ������
				session.update(obj);
				tx.commit(); // �־û�����
				session.close();
				return true;

			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) tx.rollback(); // ����
				if (session != null) session.close();
			}
			return false;
		}

		@Override
		public List select(String hql) {
			Session session = HibernateSessionFactory.getSession();
			try {
				Query query = session.createQuery(hql);
				List list = query.list();
				session.close();
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				if (session != null) session.close();
			}
			return null;
		}

		@Override
		public List select(String hql, int startIndex, int length) {
			Session session = HibernateSessionFactory.getSession();
			try {
				Query query = session.createQuery(hql);
				query.setFirstResult(startIndex); // ������ʼ��¼λ��
				query.setMaxResults(length); // ���÷��ؼ�¼��
				List list = query.list();
				session.close();
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				if (session != null) session.close();
			}
			return null;
		}

		@Override
		public List select(String hql, Object[] para) {
			Session session = HibernateSessionFactory.getSession();
			try {
				Query query = session.createQuery(hql);
				// ����para���ò���
				for (int i = 0; i < para.length; i++) {
					query.setParameter(i, para[i]);
				}
				List list = query.list();
				session.close();
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				if (session != null) session.close();
			}
			return null;
		}

		@Override
		public List select(String hql, Object[] para, int startIndex, int length) {
			Session session = HibernateSessionFactory.getSession();
			try {
				Query query = session.createQuery(hql);
				// ����para���ò���
				for (int i = 0; i < para.length; i++) {
					query.setParameter(i, para[i]);
				}
				query.setFirstResult(startIndex); // ������ʼ��¼λ��
				query.setMaxResults(length); // ���÷��ؼ�¼��
				List list = query.list();
				session.close();
				return list;
			} catch (Exception e) {
				e.printStackTrace();
				if (session != null) session.close();
			}
			return null;
		}

		@Override
		public int selectValue(String hql) {
			Session session = HibernateSessionFactory.getSession();
			try {
				Query query = session.createQuery(hql);

				Object obj = query.uniqueResult();
				session.close();
				if (obj instanceof Long)
					return ((Long) obj).intValue();
				else if (obj instanceof Integer)
					return ((Integer) obj).intValue();

			} catch (Exception e) {
				e.printStackTrace();
				if (session != null) session.close();
			}
			return 0;
		}

		@Override
		public int selectValue(String hql, Object[] para) {
			Session session = HibernateSessionFactory.getSession();
			try {
				Query query = session.createQuery(hql);
				// ����para���ò���
				for (int i = 0; i < para.length; i++) {
					query.setParameter(i, para[i]);
				}

				Object obj = query.uniqueResult();
				session.close();
				if (obj instanceof Long)
					return ((Long) obj).intValue();
				else if (obj instanceof Integer)
					return ((Integer) obj).intValue();

			} catch (Exception e) {
				e.printStackTrace();
				if (session != null) session.close();
			}
			return 0;
		}

		@Override
		public int selectPages(String hql, int pageSize) {
			Session session = HibernateSessionFactory.getSession();
			long pages_all = 0;
			try {
				Query query = session.createQuery(hql);

				List list = query.list();
				// ��ò�ѯ��¼����
				long records = list.size();
				// �����ҳ��
				pages_all = records % pageSize == 0 ? records / pageSize : records
						/ pageSize + 1; // �����ҳ��
				session.close();
				return (int) pages_all;
			} catch (Exception e) {
				e.printStackTrace();
				if (session != null) session.close();
			}
			return 0;
		}

		@Override
		public int selectPages(String hql, Object[] para, int pageSize) {
			Session session = HibernateSessionFactory.getSession();
			// ���˼�룺�Ȼ�ò�ѯ��¼������ʹ���㷨���������ҳ��ҳ��
			long pages_all = 0;
			try {
				Query query = session.createQuery(hql);
				// ����para���ò���
				for (int i = 0; i < para.length; i++) {
					query.setParameter(i, para[i]);
				}
				List list = query.list();
				// ��ò�ѯ��¼����
				long records = list.size();
				// �����ҳ��
				pages_all = records % pageSize == 0 ? records / pageSize : records
						/ pageSize + 1; // �����ҳ��
				session.close();
				return (int) pages_all;
			} catch (Exception e) {
				e.printStackTrace();
				if (session != null) session.close();
			}
			return 0;
		}

		@Override
		public List selectByPage(String hql, int startPage, int pageSize) {
			Session session = HibernateSessionFactory.getSession();
			List pList = null;
			int currentPage;
			try {
				Query query = session.createQuery(hql);
				// ���������pageSize�õ��ķ�ҳ��ҳ��
				List list = query.list();
				// ��ò�ѯ��¼����
				long records = list.size();
				// �����ҳ��

				int pages_all = (int) (records % pageSize == 0 ? records / pageSize
						: records / pageSize + 1); // �����ҳ��
				// �������Ա��ǰҳ��Ĳ���ҳ��
				if (startPage <= 1) {
					currentPage = 1;
				} else if (startPage >= pages_all) {
					currentPage = pages_all;
				} else {
					currentPage = startPage;
				}

				Query query2 = session.createQuery(hql);
				query2.setFirstResult((currentPage - 1) * pageSize);// �ӵڼ�����¼��ʼ��ѯ

				query2.setMaxResults(pageSize);// ÿҳ��ʾ��������¼
				pList = query2.list();
				session.close();

			} catch (Exception e) {
				e.printStackTrace();
				if (session != null) session.close();
			}
			return pList;
		}

		@Override
		public List selectByPage(String hql, Object[] para, int startPage,int pageSize) {
			Session session = HibernateSessionFactory.getSession();
			List pList = null;
			int currentPage;
			try {
				Query query = session.createQuery(hql);
				// ����para���ò���
				for (int i = 0; i < para.length; i++) {
					query.setParameter(i, para[i]);
				}
				List list = query.list();
				// ��ò�ѯ��¼����
				long records = list.size();
				// �����ҳ��
				int pages_all = (int) (records % pageSize == 0 ? records / pageSize
						: records / pageSize + 1); // �����ҳ��
				// �������Ա��ǰҳ��Ĳ���ҳ��

				if (startPage <= 1) {
					currentPage = 1;
				} else if (startPage >= pages_all) {
					currentPage = pages_all;
				} else {
					currentPage = startPage;
				}

				Query query2 = session.createQuery(hql);
				// ����para���ò���
				for (int i = 0; i < para.length; i++) {
					query2.setParameter(i, para[i]);

				}
				query2.setFirstResult((currentPage - 1) * pageSize);// �ӵڼ�����¼��ʼ��ѯ

				query2.setMaxResults(pageSize);// ÿҳ��ʾ��������¼
				pList = query2.list();
				session.close();

			} catch (Exception e) {
				e.printStackTrace();
				if (session != null) session.close();
			}
			return pList;
		}

		@Override
		public Object findById(Class cls, Serializable id) {
			Session session = HibernateSessionFactory.getSession();
			try {
				Object obj = session.get(cls, id);
				session.close();
				return obj;
			} catch (Exception e) {
				e.printStackTrace();
				if (session != null) session.close();
			}
			return null;
		}

		@Override
		public boolean update(String sql) {
			Session session = HibernateSessionFactory.getSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction(); // ����һ������
				// ���ỰSession����ת����jdbc��Connection
				Connection con = session.connection();
				PreparedStatement ptmt = con.prepareStatement(sql);
				int row = ptmt.executeUpdate();

				tx.commit(); // �־û�����
				session.close();

				if (row > 0)
					return true;
				else
					return false;

			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null)
					tx.rollback(); // ����
				if (session != null) session.close();
			}
			return false;

		}

		@Override
		public boolean update(String sql, Object[] para) {
			Session session = HibernateSessionFactory.getSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction(); // ����һ������
				// ���ỰSession����ת����jdbc��Connection
				Connection con = session.connection();
				PreparedStatement ptmt = con.prepareStatement(sql);
				for (int i = 0; i < para.length; i++) {
					ptmt.setObject(i + 1, para[i]);
				}
				int row = ptmt.executeUpdate();
				tx.commit(); // �־û�����
				session.close();

				if (row > 0)
					return true;
				else
					return false;

			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null)
					tx.rollback(); // ����
				if (session != null) session.close();
			}
			return false;
		}

		@Override
		public boolean delete(String sql) {
			Session session = HibernateSessionFactory.getSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction(); // ����һ������
				// ���ỰSession����ת����jdbc��Connection
				Connection con = session.connection();
				PreparedStatement ptmt = con.prepareStatement(sql);
				int row = ptmt.executeUpdate();
				tx.commit(); // �־û�����
				session.close();

				if (row > 0) return true;

				else return false;

			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) tx.rollback(); // ����
				if (session != null) session.close();
			}
			return false;

		}

		@Override
		public boolean delete(String sql, Object[] para) {
			Session session = HibernateSessionFactory.getSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction(); // ����һ������
				// ���ỰSession����ת����jdbc��Connection
				Connection con = session.connection();
				PreparedStatement ptmt = con.prepareStatement(sql);
				for (int i = 0; i < para.length; i++) {
					ptmt.setObject(i + 1, para[i]);
				}
				int row = ptmt.executeUpdate();
				tx.commit(); // �־û�����
				session.close();

				if (row > 0) return true;
				else return false;

			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) tx.rollback(); // ����
				if (session != null) session.close();
			}

			return false;

		}

		@Override
		public Object executeProduce(String procName) {
			Session session = HibernateSessionFactory.getSession();
			Transaction tx = null;
			try {

				tx = session.beginTransaction();
				Connection conn = session.connection();
				CallableStatement ctmt = conn.prepareCall("{ ?  =  call " + procName + " }");
				ctmt.registerOutParameter(1, java.sql.Types.INTEGER);

				boolean type = ctmt.execute();
				tx.commit();
				if (type) { // Ϊtrue�����洢������һ��select���
					ResultSet rs = ctmt.getResultSet();
					// globesession.close();
					return rs;
				} else { // ����select�����ȡ����ֵ

					int isSuccess = ctmt.getInt(1); // ��÷���ֵ��
					session.close();
					return new Integer(isSuccess);
				}

			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) tx.rollback(); // ����ʱ���ع�����
				if (session != null) session.close();
			}
			return null;

		}

		@Override
		public Object executeProduce(String procName, Object[] para) {
			Session session = HibernateSessionFactory.getSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				Connection conn = session.connection();
				CallableStatement ctmt = conn.prepareCall("{ ?  =  call " + procName + " }");

				ctmt.registerOutParameter(1, java.sql.Types.INTEGER);
				for (int i = 0; i < para.length; i++) {
					ctmt.setObject(i + 2, para[i]);
				}
				boolean type = ctmt.execute();

				tx.commit();
				if (type) { // Ϊtrue�����洢������һ��select���
					ResultSet rs = ctmt.getResultSet();
					// globesession.close();
					return rs;
				} else { // ����select�����ȡ����ֵ

					int isSuccess = ctmt.getInt(1); // ��÷���ֵ��
					session.close();
					return new Integer(isSuccess);
				}

			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) tx.rollback(); // ����ʱ���ع�����
				if (session != null) session.close();
			}
			return null;

		}

		@Override
		public boolean executeBatch(Object[] obj, int[] model) {
			Session session = HibernateSessionFactory.getSession();
			Transaction tx = null;
			tx = session.beginTransaction();
			try {
				for (int i = 0; i < obj.length; i++) {
					if (model[i] == INSERT)
						session.save(obj[i]);
					else if (model[i] == UPDATE)
						session.update(obj[i]);
					else if (model[i] == DELETE)
						session.delete(obj[i]);
				}
				tx.commit();
				session.close();
				return true;

			} catch (Exception e) {

				e.printStackTrace();
				if (tx != null) tx.rollback(); // ����ʱ���ع�����
				if (session != null) session.close();
			}
			return false;

		}

		@Override
		public boolean executeBatch(List<Object> list, List<Integer> models) {
			Session session = HibernateSessionFactory.getSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				for (int i = 0; i < list.size(); i++) {
					Object obj = list.get(i);
					Integer model = (Integer) models.get(i);
					if (model.intValue() == INSERT) {

						session.save(obj);
					} else if (model.intValue() == UPDATE) {
						session.update(obj);
					} else if (model.intValue() == DELETE) {
						session.delete(obj);
					}
				}
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				if (tx != null) tx.rollback(); // ����ʱ���ع�����
				if (session != null) session.close();
			}
			return false;

		}
		
		
		

}
