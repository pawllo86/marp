package marp.type;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.StringType;
import org.hibernate.usertype.UserType;

public abstract class Type implements UserType, Serializable {

	private static final long serialVersionUID = 1L;

	protected String code;

	protected Type() {}

	protected Type(String code) {
		this.code = code;
	}

	private void setCode(String code) {
		this.code = code;
	}

	@Override
	public boolean isMutable() {
		return true;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		if (x != null) {
			return x.equals(y);
		} else if(y != null) {
			return y.equals(x);
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return code;
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	@Override
	public Object replace(Object original, Object target, Object owner)
			throws HibernateException {
		return original;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	@Override
	public Object assemble(Serializable cached, Object owner)
			throws HibernateException {
		return cached;
	}

	@Override
	public Type nullSafeGet(ResultSet resultSet, String[] names, SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		Type type = null;

		String code = (String)StringType.INSTANCE.nullSafeGet(resultSet, names, session, owner);

		if (code != null) {
			try {
				type = getClass().newInstance();
				type.setCode(code);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return type;
	}

	@Override
	public void nullSafeSet(PreparedStatement preparedStatement, Object value, int index, SessionImplementor session)
			throws HibernateException, SQLException {
		String insert = value == null ? null : value.toString();

		StringType.INSTANCE.nullSafeSet(preparedStatement, insert, index, session);
	}

	@Override
	public Class<? extends Type> returnedClass() {
		return getClass();
	}

	@Override
	public int[] sqlTypes() {
		return new int[] { Types.VARCHAR };
	}

}
