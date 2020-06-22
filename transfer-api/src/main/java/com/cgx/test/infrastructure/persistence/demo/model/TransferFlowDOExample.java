package com.cgx.test.infrastructure.persistence.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransferFlowDOExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransferFlowDOExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTransactionNoIsNull() {
            addCriterion("transaction_no is null");
            return (Criteria) this;
        }

        public Criteria andTransactionNoIsNotNull() {
            addCriterion("transaction_no is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionNoEqualTo(String value) {
            addCriterion("transaction_no =", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoNotEqualTo(String value) {
            addCriterion("transaction_no <>", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoGreaterThan(String value) {
            addCriterion("transaction_no >", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_no >=", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoLessThan(String value) {
            addCriterion("transaction_no <", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoLessThanOrEqualTo(String value) {
            addCriterion("transaction_no <=", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoLike(String value) {
            addCriterion("transaction_no like", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoNotLike(String value) {
            addCriterion("transaction_no not like", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoIn(List<String> values) {
            addCriterion("transaction_no in", values, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoNotIn(List<String> values) {
            addCriterion("transaction_no not in", values, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoBetween(String value1, String value2) {
            addCriterion("transaction_no between", value1, value2, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoNotBetween(String value1, String value2) {
            addCriterion("transaction_no not between", value1, value2, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andSelfUserIdIsNull() {
            addCriterion("self_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSelfUserIdIsNotNull() {
            addCriterion("self_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSelfUserIdEqualTo(Long value) {
            addCriterion("self_user_id =", value, "selfUserId");
            return (Criteria) this;
        }

        public Criteria andSelfUserIdNotEqualTo(Long value) {
            addCriterion("self_user_id <>", value, "selfUserId");
            return (Criteria) this;
        }

        public Criteria andSelfUserIdGreaterThan(Long value) {
            addCriterion("self_user_id >", value, "selfUserId");
            return (Criteria) this;
        }

        public Criteria andSelfUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("self_user_id >=", value, "selfUserId");
            return (Criteria) this;
        }

        public Criteria andSelfUserIdLessThan(Long value) {
            addCriterion("self_user_id <", value, "selfUserId");
            return (Criteria) this;
        }

        public Criteria andSelfUserIdLessThanOrEqualTo(Long value) {
            addCriterion("self_user_id <=", value, "selfUserId");
            return (Criteria) this;
        }

        public Criteria andSelfUserIdIn(List<Long> values) {
            addCriterion("self_user_id in", values, "selfUserId");
            return (Criteria) this;
        }

        public Criteria andSelfUserIdNotIn(List<Long> values) {
            addCriterion("self_user_id not in", values, "selfUserId");
            return (Criteria) this;
        }

        public Criteria andSelfUserIdBetween(Long value1, Long value2) {
            addCriterion("self_user_id between", value1, value2, "selfUserId");
            return (Criteria) this;
        }

        public Criteria andSelfUserIdNotBetween(Long value1, Long value2) {
            addCriterion("self_user_id not between", value1, value2, "selfUserId");
            return (Criteria) this;
        }

        public Criteria andOppositeUserIdIsNull() {
            addCriterion("opposite_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOppositeUserIdIsNotNull() {
            addCriterion("opposite_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOppositeUserIdEqualTo(Long value) {
            addCriterion("opposite_user_id =", value, "oppositeUserId");
            return (Criteria) this;
        }

        public Criteria andOppositeUserIdNotEqualTo(Long value) {
            addCriterion("opposite_user_id <>", value, "oppositeUserId");
            return (Criteria) this;
        }

        public Criteria andOppositeUserIdGreaterThan(Long value) {
            addCriterion("opposite_user_id >", value, "oppositeUserId");
            return (Criteria) this;
        }

        public Criteria andOppositeUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("opposite_user_id >=", value, "oppositeUserId");
            return (Criteria) this;
        }

        public Criteria andOppositeUserIdLessThan(Long value) {
            addCriterion("opposite_user_id <", value, "oppositeUserId");
            return (Criteria) this;
        }

        public Criteria andOppositeUserIdLessThanOrEqualTo(Long value) {
            addCriterion("opposite_user_id <=", value, "oppositeUserId");
            return (Criteria) this;
        }

        public Criteria andOppositeUserIdIn(List<Long> values) {
            addCriterion("opposite_user_id in", values, "oppositeUserId");
            return (Criteria) this;
        }

        public Criteria andOppositeUserIdNotIn(List<Long> values) {
            addCriterion("opposite_user_id not in", values, "oppositeUserId");
            return (Criteria) this;
        }

        public Criteria andOppositeUserIdBetween(Long value1, Long value2) {
            addCriterion("opposite_user_id between", value1, value2, "oppositeUserId");
            return (Criteria) this;
        }

        public Criteria andOppositeUserIdNotBetween(Long value1, Long value2) {
            addCriterion("opposite_user_id not between", value1, value2, "oppositeUserId");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Long value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Long value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Long value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Long value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Long value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Long> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Long> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Long value1, Long value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Long value1, Long value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNull() {
            addCriterion("gmt_created is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNotNull() {
            addCriterion("gmt_created is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedEqualTo(Date value) {
            addCriterion("gmt_created =", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotEqualTo(Date value) {
            addCriterion("gmt_created <>", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThan(Date value) {
            addCriterion("gmt_created >", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_created >=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThan(Date value) {
            addCriterion("gmt_created <", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_created <=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIn(List<Date> values) {
            addCriterion("gmt_created in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotIn(List<Date> values) {
            addCriterion("gmt_created not in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedBetween(Date value1, Date value2) {
            addCriterion("gmt_created between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_created not between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
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