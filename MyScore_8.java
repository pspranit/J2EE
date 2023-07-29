package com.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.dao.MyScoreDAO;
import com.google.gson.Gson;
import com.identityIQ3Score_dto.IdentityIQ3ScoreMyScoreRemark;
import com.identityIQ3Score_dto.IdentityIQScore3MyScoreName;
import com.myscore_dto.MyScoreAccount;
import com.myscore_dto.MyScoreAddress;
import com.myscore_dto.MyScoreAttributes;
import com.myscore_dto.MyScoreComment;
import com.myscore_dto.MyScoreConsumerStatements;
import com.myscore_dto.MyScoreCreditScoreContent;
import com.myscore_dto.MyScoreCreditScoreFactor;
import com.myscore_dto.MyScoreCreditor;
import com.myscore_dto.MyScoreData;
import com.myscore_dto.MyScoreEmployer;
import com.myscore_dto.MyScoreFactor;
import com.myscore_dto.MyScoreFraudInfo;
import com.myscore_dto.MyScoreGroupBy;
import com.myscore_dto.MyScoreInquiry;
import com.myscore_dto.MyScorePaymentHistory;
import com.myscore_dto.MyScorePublicRecords;
import com.myscore_dto.MyScoreReportError;
import com.myscore_dto.MyScoreRoot;
import com.myscore_dto.MyScoreScoreDetail;

public class MyScore_8 {
	public static MyScoreRoot getJsonFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/home/kaldin/Downloads/reports/myscoreIQ.json"));
		String line;
		StringBuffer sbuilderObj = new StringBuffer();
		while ((line = br.readLine()) != null)
			sbuilderObj.append(line);
		String json = sbuilderObj.toString();
//		System.out.println(json);
		Gson gson = new Gson();
		MyScoreRoot myScoreRoot = gson.fromJson(json, MyScoreRoot.class);
		return myScoreRoot;
	}

	public static void main(String[] args) throws IOException, SQLException, ParseException {
		MyScoreDAO myScoreDAO = new MyScoreDAO();

		MyScoreRoot myScoreRoot = MyScore_8.getJsonFile();
		MyScoreGroupBy myScoreGroupBy = myScoreRoot.getGroupBy();
		System.out.println("order_id : " + myScoreGroupBy.getOrderId());
		myScoreGroupBy.setOrderId(myScoreGroupBy.getOrderId());
//		myScoreDAO.insertGroupBy(myScoreGroupBy);
		int dataId = 0;
		List<MyScoreData> myScoreDataList = myScoreRoot.getData();
		for (MyScoreData data : myScoreDataList) {
			dataId++;
			System.out.println(data.getReportId());
			data.setReportId(data.getReportId());
			System.out.println(data.getOrderId());
			data.setOrderId(data.getOrderId());
			System.out.println(data.getBureau());
			data.setBureau(data.getBureau());
			System.out.println(data.getReportDate());
			data.setReportDate(data.getReportDate());
			System.out.println(data.getViewDate());
			data.setViewDate(data.getViewDate());
			System.out.println(data.getYearOfBirth());
			data.setYearOfBirth(data.getYearOfBirth());
//			myScoreDAO.insertData(data,dataId);
			System.out.println("*********Account**********");
			int accountId = 0;
			List<MyScoreAccount> myScoreAccountsList = data.getAccounts();
			for (MyScoreAccount account : myScoreAccountsList) {
				accountId++;
				System.out.println("********(" + accountId + ")*********");
				System.out.println(account.getName());
				account.setName(account.getName());
				System.out.println(account.getNumber());
				account.setNumber(account.getNumber());
				System.out.println(account.getType());
				account.setType(account.getType());
				System.out.println(account.getBalance());
				account.setBalance(account.getBalance());
				System.out.println(account.getBalanceDate());
				account.setBalanceDate(account.getBalanceDate());
				System.out.println(account.getBusinessType());
				account.setBusinessType(account.getBusinessType());
				System.out.println(account.getClassification());
				account.setClassification(account.getClassification());
				System.out.println(account.getDateOpened());
				account.setDateOpened(account.getDateOpened());
				System.out.println(account.getStatusDate());
				account.setStatusDate(account.getStatusDate());
				System.out.println(account.getDelinquent30DaysCount());
				account.setDelinquent30DaysCount(account.getDelinquent30DaysCount());
				System.out.println(account.getDelinquent60DaysCount());
				account.setDelinquent60DaysCount(account.getDelinquent60DaysCount());
				System.out.println(account.getDelinquent90DaysCount());
				account.setDelinquent90DaysCount(account.getDelinquent90DaysCount());
				System.out.println(account.getHighBalance());
				account.setHighBalance(account.getHighBalance());
				System.out.println(account.getLimit());
				account.setLimit(account.getLimit());
				System.out.println(account.getMonthlyPayment());
				account.setMonthlyPayment(account.getMonthlyPayment());
				System.out.println(account.getOriginalAmount());
				account.setOriginalAmount(account.getOriginalAmount());
				System.out.println(account.getOriginalCreditor());
				account.setOriginalCreditor(account.getOriginalCreditor());
				System.out.println(account.getResponsibility());
				account.setResponsibility(account.getResponsibility());
				System.out.println(account.getTerms());
				account.setTerms(account.getTerms());
				System.out.println(account.getCreditorCommentsRaw());
				account.setCreditorCommentsRaw(account.getCreditorCommentsRaw());
				System.out.println(account.getTypeDefinitionFlags().getIsExternalCollection());
				account.getTypeDefinitionFlags()
						.setIsExternalCollection(account.getTypeDefinitionFlags().getIsExternalCollection());
				System.out.println(account.getTypeDefinitionFlags().getIsTrade());
				account.getTypeDefinitionFlags().setIsTrade(account.getTypeDefinitionFlags().getIsTrade());
//				myScoreDAO.insertAccounts(account,dataId);
				List<MyScoreComment> commentList = account.getComments();
				for (MyScoreComment comment : commentList) {
					System.out.println(comment.getCommentText());
					comment.setCommentText(comment.getCommentText());
//				myScoreDAO.insertComment(comment,accountId);
				}
				if (account.getCreditor() != null) {
//					myScoreDAO.insertCreditor(account.getCreditor(),accountId);
				}
				if (account.getPaymentHistories() != null) {
					List<MyScorePaymentHistory> myScorePaymentHistoryList = account.getPaymentHistories();
					for (MyScorePaymentHistory payHistory : myScorePaymentHistoryList) {
//						myScoreDAO.insertMyScorePaymentHistory(payHistory,accountId);
					}
				}
				if (account.getRemarks() != null) {
					List<IdentityIQ3ScoreMyScoreRemark> myScoreRemarksList = account.getRemarks();
					for (IdentityIQ3ScoreMyScoreRemark myScoreRemark : myScoreRemarksList) {
						System.out.println(myScoreRemark.getCustomRemark());
						System.out.println(myScoreRemark.getRemarkCode());
					}
				}
			}

			if (data.getFraudInfo() != null) {
				List<MyScoreFraudInfo> fraudInfosList = data.getFraudInfo();
				for (MyScoreFraudInfo fraudInfo : fraudInfosList) {
				}
			}
			System.out.println("*******NAMES********");
			List<IdentityIQScore3MyScoreName> identityIQScore3MyScoreNamesList = data.getNames();
			for (IdentityIQScore3MyScoreName iqScore3MyScoreName : identityIQScore3MyScoreNamesList) {
				System.out.println(iqScore3MyScoreName.getFirst());
				iqScore3MyScoreName.setFirst(iqScore3MyScoreName.getFirst());
				System.out.println(iqScore3MyScoreName.getMiddle());
				iqScore3MyScoreName.setMiddle(iqScore3MyScoreName.getMiddle());
				System.out.println(iqScore3MyScoreName.getLast());
				iqScore3MyScoreName.setLast(iqScore3MyScoreName.getLast());
//				myScoreDAO.insertnames(iqScore3MyScoreName,dataId);
			}
			List<MyScoreAddress> addressesList = data.getAddresses();
			System.out.println("*******Adressess*******");
			for (MyScoreAddress address : addressesList) {
				System.out.println(address.getHouseNumber());
				address.setHouseNumber(address.getHouseNumber());
				System.out.println(address.getPreDirectional());
				address.setPreDirectional(address.getPostDirectional());
				System.out.println(address.getStreetName());
				address.setStreetName(address.getStreetName());
				System.out.println(address.getSuffix());
				address.setSuffix(address.getSuffix());
				System.out.println(address.getPostDirectional());
				address.setPostDirectional(address.getPostDirectional());
				System.out.println(address.getUnit());
				address.setUnit(address.getUnit());
				System.out.println(address.getCity());
				address.setCity(address.getCity());
				System.out.println(address.getState());
				address.setState(address.getState());
				System.out.println(address.getZipcode());
				address.setZipcode(address.getZipcode());
				System.out.println(address.getResidenceType());
				address.setResidenceType(address.getResidenceType());
				System.out.println(address.getDateFirstReported());
				address.setDateFirstReported(address.getDateFirstReported());
				System.out.println(address.getDateLastpdated());
				address.setDateLastpdated(address.getDateLastpdated());
//				myScoreDAO.insertAdressess(address,dataId);
			}
			int inquiryId = 0;
			List<MyScoreInquiry> inquiriesList = data.getInquiries();
			System.out.println("*******inquiries*******");
			for (MyScoreInquiry inquiry : inquiriesList) {
				inquiryId++;
				System.out.println(inquiry.getCompanyName());
				inquiry.setCompanyName(inquiry.getCompanyName());
				System.out.println(inquiry.getCompanyType());
				inquiry.setCompanyType(inquiry.getCompanyType());
				System.out.println(inquiry.getDateOfInquiry());
				inquiry.setDateOfInquiry(inquiry.getDateOfInquiry());
//				myScoreDAO.insertInquiries(inquiry,dataId);
				if (inquiry.getCreditor() != null) {
					MyScoreCreditor creditor = inquiry.getCreditor();
					System.out.println(creditor.getPhone());
					creditor.setName(creditor.getPhone());
					System.out.println(creditor.getName());
					creditor.setName(creditor.getName());
					System.out.println(creditor.getAddress());
					creditor.setAddress(creditor.getAddress());
					System.out.println(creditor.getCity());
					creditor.setCity(creditor.getCity());
					System.out.println(creditor.getState());
					creditor.setState(creditor.getState());
					System.out.println(creditor.getZipcode());
					creditor.setZipcode(creditor.getZipcode());
//					myScoreDAO.insertCreditor(creditor,inquiryId);
				}
			}
			if (data.getEmployers() != null) {
				System.out.println("*******employers*******");
				List<MyScoreEmployer> employersList = data.getEmployers();
				for (MyScoreEmployer employer : employersList) {
					System.out.println(employer.getName());
					employer.setName(employer.getName());
					System.out.println(employer.getDateFirstReported());
					employer.setDateFirstReported(employer.getDateFirstReported());
					System.out.println(employer.getDateLastUpdated());
					employer.setDateLastUpdated(employer.getDateLastUpdated());
//					myScoreDAO.insertEmployer(employer,dataId);
				}
			}
			if (data.getPublicRecords() != null) {
				List<MyScorePublicRecords> publicRecordsList = data.getPublicRecords();
				for (MyScorePublicRecords records : publicRecordsList) {
				}
			}
			if (data.getConsumerStatements() != null) {
				List<MyScoreConsumerStatements> consumerStatementsList = data.getConsumerStatements();
				for (MyScoreConsumerStatements records : consumerStatementsList) {
				}
			}
			System.out.println("*******Source_Details*********");
			int sourceId = 0;
			if (data.getScoreDetails() != null) {
				List<MyScoreScoreDetail> scoreDetailsList = data.getScoreDetails();
				for (MyScoreScoreDetail detail : scoreDetailsList) {
					sourceId++;
					System.out.println(detail.getBureau());
					detail.setBureau(detail.getBureau());
					System.out.println(detail.getModel());
					detail.setModel(detail.getModel());
					System.out.println(detail.getScore());
					detail.setScore(detail.getScore());
					System.out.println(detail.getScoreRating());
					detail.setScoreRating(detail.getScoreRating());
					System.out.println(detail.getScoreDt());
					detail.setScoreDt(detail.getScoreDt());
					System.out.println(detail.getSourceProcessRecordId());
					detail.setSourceProcessRecordId(detail.getSourceProcessRecordId());
					System.out.println(detail.getSourceProcessTypeName());
					detail.setSourceProcessTypeName(detail.getSourceProcessTypeName());
					System.out.println(detail.getOrderNumber());
					detail.setOrderNumber(detail.getOrderNumber());
					System.out.println(detail.getExcludeFromReport());
					detail.setExcludeFromReport(detail.getExcludeFromReport());
					System.out.println(detail.getCreditScoreId());
					detail.setCreditScoreId(detail.getCreditScoreId());
//					myScoreDAO.insertScoreDetails(detail,dataId);
					int scoreFactorId = 0;
					MyScoreCreditScoreFactor creditScoreFactor = detail.getCreditScoreFactor();
					if (creditScoreFactor != null) {
						System.out.println(creditScoreFactor.getCreditScoreId());
//						myScoreDAO.insertcreditScoreFactor(creditScoreFactor.getCreditScoreId(),sourceId);
						scoreFactorId++;
						List<MyScoreFactor> factorsList = creditScoreFactor.getFactors();
						for (MyScoreFactor factor : factorsList) {
							System.out.println(factor.getSequence());
							factor.setSequence(factor.getSequence());
							System.out.println(factor.getCode());
							factor.setCode(factor.getCode());
							System.out.println(factor.getValue());
							factor.setValue(factor.getValue());
							System.out.println(factor.getIsPositive());
							factor.setIsPositive(factor.getIsPositive());
//							myScoreDAO.insertFactor(factor,scoreFactorId);
						}
					}
					MyScoreCreditScoreContent content = detail.getCreditScoreContent();
					System.out.println(content.getContent());
					content.setContent(content.getContent());
					System.out.println(content.getScore());
					content.setScore(content.getScore());
					System.out.println(content.getCreditScoreId());
					content.setCreditScoreId(content.getCreditScoreId());
//					myScoreDAO.insertCreditScoreContent(content,scoreFactorId);
				}
			}
			System.out.println("******Attributes********");
			List<MyScoreAttributes> attributesList = data.getAttributes();
			if (attributesList != null) {
				for (MyScoreAttributes attributes : attributesList) {
				}
			}
			System.out.println("******Report_Error********");
			List<MyScoreReportError> errorsList=data.getReportErrors();
			if(errorsList!=null)
			{
				for(MyScoreReportError error :errorsList)
				{
					System.out.println(error.getMessage());
					error.setMessage(error.getMessage());
					System.out.println(error.getSeverity());
					error.setSeverity(error.getSeverity());
					System.out.println(error.getSegmentId());
					error.setSegmentId(error.getSegmentId());
					System.out.println(error.getSequenceId());
					error.setSequenceId(error.getSequenceId());
//					myScoreDAO.insertReportError(error,dataId);
				}
			}
			break;
		} // data
	}
}
