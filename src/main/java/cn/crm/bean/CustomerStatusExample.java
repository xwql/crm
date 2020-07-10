package cn.crm.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerStatusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerStatusExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCustIdIsNull() {
            addCriterion("custId is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("custId is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(Long value) {
            addCriterion("custId =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(Long value) {
            addCriterion("custId <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(Long value) {
            addCriterion("custId >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(Long value) {
            addCriterion("custId >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(Long value) {
            addCriterion("custId <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(Long value) {
            addCriterion("custId <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<Long> values) {
            addCriterion("custId in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<Long> values) {
            addCriterion("custId not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(Long value1, Long value2) {
            addCriterion("custId between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(Long value1, Long value2) {
            addCriterion("custId not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustStatusIsNull() {
            addCriterion("custStatus is null");
            return (Criteria) this;
        }

        public Criteria andCustStatusIsNotNull() {
            addCriterion("custStatus is not null");
            return (Criteria) this;
        }

        public Criteria andCustStatusEqualTo(String value) {
            addCriterion("custStatus =", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusNotEqualTo(String value) {
            addCriterion("custStatus <>", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusGreaterThan(String value) {
            addCriterion("custStatus >", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusGreaterThanOrEqualTo(String value) {
            addCriterion("custStatus >=", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusLessThan(String value) {
            addCriterion("custStatus <", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusLessThanOrEqualTo(String value) {
            addCriterion("custStatus <=", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusLike(String value) {
            addCriterion("custStatus like", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusNotLike(String value) {
            addCriterion("custStatus not like", value, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusIn(List<String> values) {
            addCriterion("custStatus in", values, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusNotIn(List<String> values) {
            addCriterion("custStatus not in", values, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusBetween(String value1, String value2) {
            addCriterion("custStatus between", value1, value2, "custStatus");
            return (Criteria) this;
        }

        public Criteria andCustStatusNotBetween(String value1, String value2) {
            addCriterion("custStatus not between", value1, value2, "custStatus");
            return (Criteria) this;
        }

        public Criteria andDeletereasonIsNull() {
            addCriterion("deletereason is null");
            return (Criteria) this;
        }

        public Criteria andDeletereasonIsNotNull() {
            addCriterion("deletereason is not null");
            return (Criteria) this;
        }

        public Criteria andDeletereasonEqualTo(String value) {
            addCriterion("deletereason =", value, "deletereason");
            return (Criteria) this;
        }

        public Criteria andDeletereasonNotEqualTo(String value) {
            addCriterion("deletereason <>", value, "deletereason");
            return (Criteria) this;
        }

        public Criteria andDeletereasonGreaterThan(String value) {
            addCriterion("deletereason >", value, "deletereason");
            return (Criteria) this;
        }

        public Criteria andDeletereasonGreaterThanOrEqualTo(String value) {
            addCriterion("deletereason >=", value, "deletereason");
            return (Criteria) this;
        }

        public Criteria andDeletereasonLessThan(String value) {
            addCriterion("deletereason <", value, "deletereason");
            return (Criteria) this;
        }

        public Criteria andDeletereasonLessThanOrEqualTo(String value) {
            addCriterion("deletereason <=", value, "deletereason");
            return (Criteria) this;
        }

        public Criteria andDeletereasonLike(String value) {
            addCriterion("deletereason like", value, "deletereason");
            return (Criteria) this;
        }

        public Criteria andDeletereasonNotLike(String value) {
            addCriterion("deletereason not like", value, "deletereason");
            return (Criteria) this;
        }

        public Criteria andDeletereasonIn(List<String> values) {
            addCriterion("deletereason in", values, "deletereason");
            return (Criteria) this;
        }

        public Criteria andDeletereasonNotIn(List<String> values) {
            addCriterion("deletereason not in", values, "deletereason");
            return (Criteria) this;
        }

        public Criteria andDeletereasonBetween(String value1, String value2) {
            addCriterion("deletereason between", value1, value2, "deletereason");
            return (Criteria) this;
        }

        public Criteria andDeletereasonNotBetween(String value1, String value2) {
            addCriterion("deletereason not between", value1, value2, "deletereason");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andDeletetimeIsNull() {
            addCriterion("deletetime is null");
            return (Criteria) this;
        }

        public Criteria andDeletetimeIsNotNull() {
            addCriterion("deletetime is not null");
            return (Criteria) this;
        }

        public Criteria andDeletetimeEqualTo(Date value) {
            addCriterion("deletetime =", value, "deletetime");
            return (Criteria) this;
        }

        public Criteria andDeletetimeNotEqualTo(Date value) {
            addCriterion("deletetime <>", value, "deletetime");
            return (Criteria) this;
        }

        public Criteria andDeletetimeGreaterThan(Date value) {
            addCriterion("deletetime >", value, "deletetime");
            return (Criteria) this;
        }

        public Criteria andDeletetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deletetime >=", value, "deletetime");
            return (Criteria) this;
        }

        public Criteria andDeletetimeLessThan(Date value) {
            addCriterion("deletetime <", value, "deletetime");
            return (Criteria) this;
        }

        public Criteria andDeletetimeLessThanOrEqualTo(Date value) {
            addCriterion("deletetime <=", value, "deletetime");
            return (Criteria) this;
        }

        public Criteria andDeletetimeIn(List<Date> values) {
            addCriterion("deletetime in", values, "deletetime");
            return (Criteria) this;
        }

        public Criteria andDeletetimeNotIn(List<Date> values) {
            addCriterion("deletetime not in", values, "deletetime");
            return (Criteria) this;
        }

        public Criteria andDeletetimeBetween(Date value1, Date value2) {
            addCriterion("deletetime between", value1, value2, "deletetime");
            return (Criteria) this;
        }

        public Criteria andDeletetimeNotBetween(Date value1, Date value2) {
            addCriterion("deletetime not between", value1, value2, "deletetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
