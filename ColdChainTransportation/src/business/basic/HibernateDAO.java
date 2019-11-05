package business.basic;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.sql.Insert;

/**
 * ����hibernate����ʵ�ֵ�BaseDAO����
 * @author �Ž�ʢ 
 * @since 2014-12-19
 * @version 2017-4-20
 */
public interface HibernateDAO {
/**
 * ʵ�ֵ�������˲ʱʵ�������ĳ־û���������Ӷ������ݿ��У�
 * ��hibernate��ӷ��������ڶԵ�����˲ʱ������г־û�����
 * @param Object �����Hibernate�ı�ӳ��ʵ�������
 * @return Object  ����id�� null���ʾ���ʧ�� 
 */
public Object insert(Object obj);

/**
 * ʵ����������˲ʱʵ�������ĳ־û���������Ӷ������ݿ��У�
 * ��hibernate��ӷ��������ڶԵ�����˲ʱ������г־û�����
 * @param List<Object> �����Hibernate�ı�ӳ��ʵ��������б�
 * @return boolean  true�ɹ���falseʧ��
 */
public boolean insert(List<Object> list);

/**
 * ִ�б�����ɾ������
 * ��hibernateɾ�����������ڶԵ�����˲ʱ����ʹ����id���Խ��г־û�����
 * @param Class ������Ӧ���Pojo�����ͣ���User.class
 * @param Serializable ��Ӧ���������ֶε�Pojo��ĳ�Ա���Ե�ֵ�����û����id
 * @return boolean true �ɹ�    false ʧ��
 */
public boolean delete(Class cls, java.io.Serializable id);

/**
 * ִ�б�����ɾ������
 * ��hibernateɾ�����������ڶԵ�����˲ʱ������г־û�ɾ������
 * @param Object Hibernate�ı�ӳ����� ��ǰΪҪɾ�����ʵ�������
 * @return boolean true �ɹ�    false ʧ��
 */
public boolean delete(Object obj) ;

/**
 * �޸ı��¼��ʹ�ö�Ӧ���ʵ�������ʵ��
 * ��hibernate���·��������ڶԵ�����˲ʱ������г־û�����
 * @param Object Hibernate�ı�ӳ�����
 * @return boolean true �ɹ�    false ʧ��
 */
public boolean update(Object obj) ;

/**
 * ʹ���޲�����hqlʵ�ֲ�ѯ�ģ��������ػ���hql�в�ѯ�����List�������
 * @param String ����hql�ṹ���޲�����ѯ���
 * @return List  ʧ�ܷ���null
 */
public List select(String hql) ;

/**
 * ʹ���޲�����hqlʵ�ֲ�ѯ�ģ��������ػ���hql�в�ѯ�����List�������,ʵ��top����
 * @param String ����hql�ṹ���޲�����ѯ���
 * @param String ȡListֵ�Ŀ�ʼ����
 * @param String ȡListֵ�ý�������
 * @return List  ʧ�ܷ���null
 */
public List select(String hql,int startIndex, int length) ;

/**
 * ʹ�ô��в�����hqlʵ�ֲ�ѯ�ģ��������ػ���hql�в�ѯ�����List�������
 * @param String ����hql�ṹ���в�����ѯ���
 * @param Object[] ����ֵ����
 * @return List  ʧ�ܷ���null
 */
public List select(String hql,Object[] para) ;

/**
 * ʹ���޲�����hqlʵ�ֲ�ѯ�ģ��������ػ���hql�в�ѯ�����List�������,ʵ��top����
 * @param String ����hql�ṹ���޲�����ѯ���
 * @param String ȡListֵ�Ŀ�ʼ����
 * @param String ȡListֵ�ý�������
 * @return List  ʧ�ܷ���null
 */
public List select(String hql,Object[] para,
		int startIndex, int length) ;

/**
 * ��ȡ���ۺϺ���hql���Ĳ�ѯ���
 * @param hql ���ۺϺ�����hql�ṹ���޲�����ѯ���
 * @return List  ʧ�ܷ���null
 */
public int selectValue(String hql);

/**
 * ʹ�ô��в�����hql,��ȡ�ۺϺ�����ѯ�Ľ��
 * @param hql ���ۺϺ�����hql�ṹ���в�����ѯ���
 * @param para Object[]���͵Ĳ���ֵ����
 * @return List  ʧ�ܷ���null
 */
public int selectValue(String hql,Object[] para);

/**
 * ��ҳ��ѯ������ҳ��
 * ��ʹ�õ�hql���Ϊ(1)"from DForum" 
 * (2)from DForum order by forumid desc"
 * (3)from DForum where DUser.userid = 'zhangjs' order by forumid desc"
 * @param String hql ��ҳ��ѯ��hql�ַ���
 * @param String pageSize ÿҳ�Ľ������
 * @return int ��ѯ�õ�����ҳ�����
 */
public int selectPages(String hql,int pageSize);

/**
 * ��ҳ��ѯ������ҳ��
 * ��ʹ�õ�hql���Ϊ(1)"from DForum" 
 * (2)from DForum order by forumid desc"
 * (3)from DForum where DUser.userid = 'zhangjs' order by forumid desc"
 * @param String hql ��ҳ��ѯ��hql�ַ���
 * @param Object[] para ��Ӧhql�в�����ֵ����
 * @param String pageSize ÿҳ�Ľ������
 * @return int ��ѯ�õ�����ҳ�����
 */
public int selectPages(String hql,Object[] para, int pageSize);

/**
 * ��ҳ��ѯ
 * ��ʹ�õ�hql���Ϊ(1)"from DForum" 
 * (2)from DForum order by forumid desc"
 * (3)from DForum where DUser.userid = 'zhangjs' order by forumid desc"
 * @param String hql ��ҳ��ѯ���޲���hql�ַ���
 * @param int startPage ��ѯ��ʼ��ҳ��
 * @param int pageSize ��ѯҪ���ÿҳ�ļ�¼��
 * @return List ��ѯ���صļ�¼����
 */
public List selectByPage(String hql,int startPage, int pageSize);

/**
 * ��ҳ��ѯ
 * ��ʹ�õ�hql���Ϊ(1)"from DForum" 
 * (2)from DForum order by forumid desc"
 * (3)from DForum where DUser.userid = 'zhangjs' order by forumid desc"
 * @param String hql ��ҳ��ѯ���޲���hql�ַ���
 * @param Object[] para ��Ӧ��ҳ��ѯhql�в�����ֵ����
 * @param int startPage ��ѯ��ʼ��ҳ��
 * @param int pageSize ��ѯҪ���ÿҳ�ļ�¼��
 * @return List ��ѯ���صļ�¼����
 */
public List selectByPage(String hql,Object[] para, int startPage, int pageSize);

/**
 * ����cls��Ӧ�����������id����ѯ������cls���͵Ķ���
 * @param Class cls Ҫ��ѯ��Hibernate�ı�ӳ�������������User���������ΪUser.class
 * @param java.io.Serializable id ��ѯ���õĶ�Ӧ������ֵ
 * @return Object ���ص�cls���͵Ķ���
 */
public Object findById(Class cls, java.io.Serializable id);

/**
 * �����޲�����sqlʵ�����ݱ����ĸ��²���
 * @param String sql �޲�����update��sql���
 * @return boolean true �ɹ�   false ʧ��
 */
public boolean update(String sql);

/**
 * ���ô�������sqlʵ�����ݱ����ĸ��²���
 * @param String sql ��������update��sql���
 * @param Object[] para ��Ӧsql����еĲ���ֵ
 * @return boolean true �ɹ�   false ʧ��
 */
public boolean update(String hql,Object[] para);

/**
 * ����sqlʵ�����ݱ������ɾ��
 * @param String sql �޲�����delete��sql���
 * @return boolean true �ɹ�   false ʧ��
 */
public boolean delete(String sql);

/**
 * ���ô�������sqlʵ�����ݱ������ɾ��
 * @param String sql ��������delete��sql���
 * @param Object[] para ��Ӧsql����еĲ���ֵ
 * @return boolean true �ɹ�   false ʧ��
 */
public boolean delete(String sql,Object[] para);

/**
 * �������ݿ�洢���̣��޲�����
 * ������String procName ���ݿ�洢������
 * �������:ResultSet rs ���ش洢�����в�ѯ�Ľ��
 * ����ֵ��0 �������ִ��ʧ��   >0 �������ɹ�
 */
public Object executeProduce(String procName);

/**
 * �������ݿ�洢���̣���������
 * ������String procName ���ݿ�洢������
 * �������:ResultSet rs ���ش洢�����в�ѯ�Ľ��
 * ����ֵ��0 �������ִ��ʧ��   >0 �������ɹ�
 */
public Object executeProduce(String procName,Object[] para);

/**
 * ִ�и��²�������������䣬���ｫ���ö�����������ʽ��һ���ύ��һ��ع�
 * 
 * @param Object Hibernate�ı�ӳ����� ��ǰΪҪɾ�����ʵ�������
 * @return boolean true �ɹ�    false ʧ��
 */
public boolean executeBatch(Object[] obj, int[] model);

public boolean executeBatch(List<Object> list,List<Integer> models);
	
	
}

