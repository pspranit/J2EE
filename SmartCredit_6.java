package com.controller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;
import com.identityIQ3Score_dto.Birth;
import com.identityIQ3Score_dto.BorrowerAddress;
import com.identityIQ3Score_dto.BorrowerName;
import com.identityIQ3Score_dto.BundleComponent;
import com.identityIQ3Score_dto.Bureau;
import com.identityIQ3Score_dto.Code;
import com.identityIQ3Score_dto.CreditAddress;
import com.identityIQ3Score_dto.CreditScore;
import com.identityIQ3Score_dto.CreditScoreFactor;
import com.identityIQ3Score_dto.CreditScoreType;
import com.identityIQ3Score_dto.CreditStatement;
import com.identityIQ3Score_dto.Employer;
import com.identityIQ3Score_dto.FactorText;
import com.identityIQ3Score_dto.GrantedTrade;
import com.identityIQ3Score_dto.IdentityIQ3ScoreMyScoreRemark;
import com.identityIQ3Score_dto.IndustryCode;
import com.identityIQ3Score_dto.Inquiry;
import com.identityIQ3Score_dto.InquiryPartition;
import com.identityIQ3Score_dto.MonthlyPayStatus;
import com.identityIQ3Score_dto.PaymentStatusHistory;
import com.identityIQ3Score_dto.PreviousAddress;
import com.identityIQ3Score_dto.Root;
import com.identityIQ3Score_dto.SB68Frozen;
import com.identityIQ3Score_dto.Social;
import com.identityIQ3Score_dto.Source;
import com.identityIQ3Score_dto.StatementType;
import com.identityIQ3Score_dto.Subscriber;
import com.identityIQ3Score_dto.Summary;
import com.identityIQ3Score_dto.TradeLinePartition;
import com.identityIQ3Score_dto.Tradeline;
import com.identityIQ3Score_dto.TradelineSummaryEquifax;
import com.identityIQ3Score_dto.TradelineSummaryExperian;
import com.identityIQ3Score_dto.TradelineSummaryMerge;
import com.identityIQ3Score_dto.TradelineSummaryTransUnion;
import com.identityIQ3Score_dto.TrueLinkCreditReportType;
import com.myscore_dto.MyScoreRoot;

import SmartCredit_6_dto.SmartCreditBundleComponent;
import SmartCredit_6_dto.SmartCreditRoot;
public class SmartCredit_6 {
	
	public static Root getJsonFile() throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("/home/kaldin/Downloads/reports/smart_credit.json"));
		String line;
		StringBuffer sbuilderObj = new StringBuffer();
		while ((line = br.readLine()) != null)
			sbuilderObj.append(line);
		String json = sbuilderObj.toString();
		Gson gson = new Gson();
		Root creditRoot = gson.fromJson(json, Root.class);
		return creditRoot;
	}
	public static void main(String[] args) throws IOException {
		
		Root creditRoot=SmartCredit_6.getJsonFile();
		System.out.println(creditRoot.toString());
		List<BundleComponent> bundleComponentsList = creditRoot.getBundleComponents().getBundleComponent();
		int bundleComponentsListLength = bundleComponentsList.size();
		System.out.println("============Type==========");
		for (int i = 0; i < bundleComponentsList.size(); i++) {
			BundleComponent bundleComponentObj = bundleComponentsList.get(i);
			CreditScoreType creditScoreType=bundleComponentObj.getCreditScoreType();
			if (creditScoreType!=null) {
				System.out.println("==================CreditScoreType===================");
				System.out.println("@ScoreName : " + creditScoreType.getScoreName());
				System.out.println("@PopulationRank : " + creditScoreType.getPopulationRank());
				System.out.println("@RiskScore : " + creditScoreType.getRiskScore());
				System.out.println("=================CreditScoreFactor====================");
				List<CreditScoreFactor> creditScoreFactorList = bundleComponentObj.getCreditScoreType()
						.getCreditScoreFactor();
				int creditScoreFactorListLength = creditScoreFactorList.size();
				for (int f = 0; f < creditScoreFactorListLength; f++) {
					System.out.println("************(" + f + ")***************");
					System.out.println("@bureauCode : " + creditScoreFactorList.get(f).getBureauCode());
					System.out.println("@FactorType : " + creditScoreFactorList.get(f).getFactorType());
					System.out.println("@Abbreviation : " + creditScoreFactorList.get(f).getFactor().getAbbreviation());
					System.out.println("@Description : " + creditScoreFactorList.get(f).getFactor().getDescription());
					System.out.println("@Symbol : " + creditScoreFactorList.get(f).getFactor().getSymbol());
					System.out.println("@Rank : " + creditScoreFactorList.get(f).getFactor().getRank());
					if (creditScoreFactorList.get(f).getFactorText() != null) {
						List<FactorText> factorTextList = creditScoreFactorList.get(f).getFactorText();
						for (int t = 0; t < factorTextList.size(); t++) {
							System.out.println("@$ : " + factorTextList.get(t).get$());
						}
					}
				}
				System.out.println("=================CreditScoreModel====================");
				System.out.println("@Abbreviation : "
						+ bundleComponentObj.getCreditScoreType().getCreditScoreModel().getAbbreviation());
				System.out.println("@Description : "
						+ bundleComponentObj.getCreditScoreType().getCreditScoreModel().getDescription());
				System.out.println(
						"@Symbol : " + bundleComponentObj.getCreditScoreType().getCreditScoreModel().getSymbol());
				System.out
						.println("@Rank : " + bundleComponentObj.getCreditScoreType().getCreditScoreModel().getRank());
				System.out.println("=================NoScoreReason====================");
				System.out.println("@Abbreviation : "
						+ bundleComponentObj.getCreditScoreType().getNoScoreReason().getAbbreviation());
				System.out.println("@Description  : "
						+ bundleComponentObj.getCreditScoreType().getNoScoreReason().getDescription());
				System.out.println("@Rank : " + bundleComponentObj.getCreditScoreType().getNoScoreReason().getRank());
				System.out
						.println("@Symbol : " + bundleComponentObj.getCreditScoreType().getNoScoreReason().getSymbol());
				System.out.println("=================Source====================");
				System.out.println(
						"@BorrowerKey : " + bundleComponentObj.getCreditScoreType().getSource().getBorrowerKey());
				System.out.println("@Abbreviation : "
						+ bundleComponentObj.getCreditScoreType().getSource().getBureau().getAbbreviation());
				System.out.println("@Description : "
						+ bundleComponentObj.getCreditScoreType().getSource().getBureau().getDescription());
				System.out.println(
						"@Rank  : " + bundleComponentObj.getCreditScoreType().getSource().getBureau().getRank());
				System.out.println(
						"@Symbol : " + bundleComponentObj.getCreditScoreType().getSource().getBureau().getSymbol());
				System.out
						.println("@$ : " + bundleComponentObj.getCreditScoreType().getSource().getInquiryDate());
				if (bundleComponentObj.getCreditScoreType().getSource().getReference() != null)
					System.out.println(
							"@$ : " + bundleComponentObj.getCreditScoreType().getSource().getReference());
				System.out.println("@$ : " + bundleComponentObj.getType());
				System.out.println("=====================================");
			} else if (bundleComponentObj.getTrueLinkCreditReportType() != null) {
				System.out.println("===============TrueLinkCreditReportType======================");
				TrueLinkCreditReportType trueLink = bundleComponentObj.getTrueLinkCreditReportType();
				System.out.println("@FraudIndicator : " + trueLink.getFraudIndicator());
				System.out.println("@DeceasedIndicator : " + trueLink.getDeceasedIndicator());
				System.out.println("=====================================");
				List<Birth> birthsList = trueLink.getBorrower().getBirth();
				System.out.println("@SocialSecurityNumber : " + trueLink.getBorrower().getSocialSecurityNumber());
				for (int j = 0; j < birthsList.size(); j++) {
					System.out.println("@Age : " + birthsList.get(j).getAge());
					System.out.println("@Date : " + birthsList.get(j).getDate());
					System.out.println("@PartitionSet : " + birthsList.get(j).getPartitionSet());
					System.out.println("@Year : " + birthsList.get(j).getBirthDate().getYear());
					System.out.println("@Month : " + birthsList.get(j).getBirthDate().getMonth());
					System.out.println("@Day : " + birthsList.get(j).getBirthDate().getDay());
					System.out.println("@BorrowerKey : " + birthsList.get(j).getSource().getBorrowerKey());
					System.out
							.println("@Abbreviation : " + birthsList.get(j).getSource().getBureau().getAbbreviation());
					System.out.println("@Description : " + birthsList.get(j).getSource().getBureau().getDescription());
					System.out.println("@Rank  : " + birthsList.get(j).getSource().getBureau().getRank());
					System.out.println("@Symbol : " + birthsList.get(j).getSource().getBureau().getSymbol());
					System.out.println("@$ : " + birthsList.get(j).getSource().getInquiryDate());
					if (birthsList.get(j).getSource().getReference() != null)
						System.out.println("@$ : " + birthsList.get(j).getSource().getReference());
				}
				System.out.println("=================BorrowerAddress====================");
				List<BorrowerAddress> borrowerAddressesList = trueLink.getBorrower().getBorrowerAddress();
				int borrowerAddressesListLength = borrowerAddressesList.size();
				for (int k = 0; k < borrowerAddressesListLength; k++) {
					BorrowerAddress borrowerAddress = borrowerAddressesList.get(k);
					System.out.println("@dateReported : " + borrowerAddress.getDateReported());
					System.out.println("@addressOrder : " + borrowerAddress.getAddressOrder());
					System.out.println("@partitionSet : " + borrowerAddress.getPartitionSet());
					System.out.println("@city : " + borrowerAddress.getCreditAddress().getCity());
					System.out.println("@direction : " + borrowerAddress.getCreditAddress().getDirection());
					System.out.println("@houseNumber : " + borrowerAddress.getCreditAddress().getHouseNumber());
					System.out.println("@postDirection : " + borrowerAddress.getCreditAddress().getPostDirection());
					System.out.println("@stateCode : " + borrowerAddress.getCreditAddress().getStateCode());
					System.out.println("@streetName : " + borrowerAddress.getCreditAddress().getStreetName());
					System.out.println("@streetType : " + borrowerAddress.getCreditAddress().getStreetType());
					System.out.println("@unit : " + borrowerAddress.getCreditAddress().getUnit());
					System.out.println("@postalCode : " + borrowerAddress.getCreditAddress().getPostalCode());
					System.out.println("================Dwelling=====================");
					System.out.println("@Abbreviation : " + borrowerAddress.getDwelling().getAbbreviation());
					System.out.println("@Description : " + borrowerAddress.getDwelling().getDescription());
					System.out.println("@Symbol  : " + borrowerAddress.getDwelling().getSymbol());
					System.out.println("@Rank : " + borrowerAddressesList.get(k).getDwelling().getRank());
					System.out.println("=================Origin====================");
					System.out.println("@Abbreviation : " + borrowerAddress.getOrigin().getAbbreviation());
					System.out.println("@Description : " + borrowerAddress.getOrigin().getDescription());
					System.out.println("@Symbol  : " + borrowerAddress.getOrigin().getSymbol());
					System.out.println("@Rank : " + borrowerAddress.getOrigin().getRank());
					System.out.println("=================Ownership====================");
					System.out.println("@Abbreviation : " + borrowerAddress.getOwnership().getAbbreviation());
					System.out.println("@Description : " + borrowerAddress.getOwnership().getDescription());
					System.out.println("@Symbol  : " + borrowerAddress.getOwnership().getSymbol());
					System.out.println("@Rank : " + borrowerAddress.getOwnership().getRank());
					System.out.println("=================Source====================");
					System.out.println("@BorrowerKey : " + borrowerAddress.getSource().getBorrowerKey());
					System.out.println("=================Bureau====================");
					System.out.println("@Abbreviation : " + borrowerAddress.getSource().getBureau().getAbbreviation());
					System.out.println("@Description : " + borrowerAddress.getSource().getBureau().getDescription());
					System.out.println("@Symbol  : " + borrowerAddress.getSource().getBureau().getSymbol());
					System.out.println("@Rank : " + borrowerAddress.getSource().getBureau().getRank());
					System.out.println("=================InquiryDate====================");
					System.out.println("@$ : " + borrowerAddress.getSource());
					System.out.println("=================Reference====================");
					if (borrowerAddress.getSource().getReference() != null)
						System.out.println("@$ : " + borrowerAddress.getSource().getReference());
				}
				System.out.println("==================BorrowerName===================");

				List<BorrowerName> borrowerNameList = trueLink.getBorrower().getBorrowerName();
				int borrowerNameListLength = borrowerNameList.size();
				for (int n = 0; n < borrowerNameListLength; n++) {
					BorrowerName borrowerName = borrowerNameList.get(n);
					System.out.println("@partitionSet : " + borrowerName.getPartitionSet());
					System.out.println("==================Name===================");
					System.out.println("@First : " + borrowerName.getName().getFirst());
					System.out.println("@Middle : " + borrowerName.getName().getMiddle());
					System.out.println("@Last : " + borrowerName.getName().getLast());
					System.out.println("==================NameType===================");
					System.out.println("@abbreviation : " + borrowerName.getNameType().getAbbreviation());
					System.out.println("@description : " + borrowerName.getNameType().getDescription());
					System.out.println("@@symbol : " + borrowerName.getNameType().getSymbol());
					System.out.println("@Rank : " + borrowerName.getNameType().getRank());
					System.out.println("=================Source====================");
					System.out.println("@BorrowerKey : " + borrowerName.getSource().getBorrowerKey());
					System.out.println("=================Bureau====================");
					System.out.println("@Abbreviation : " + borrowerName.getSource().getBureau().getAbbreviation());
					System.out.println("@Description : " + borrowerName.getSource().getBureau().getDescription());
					System.out.println("@Symbol  : " + borrowerName.getSource().getBureau().getSymbol());
					System.out.println("@Rank : " + borrowerName.getSource().getBureau().getRank());
					System.out.println("=================InquiryDate====================");
					System.out.println("@$ : " + borrowerName.getSource().getInquiryDate());
					System.out.println("=================Reference====================");
					if (borrowerName.getSource().getReference() != null)
						System.out.println("@$ : " + borrowerName.getSource().getReference());
				}
				List<CreditScore> creditScoreList = trueLink.getBorrower().getCreditScore();
				for (int c = 0; c < creditScoreList.size(); c++) {
					System.out.println("@RiskScore : " + creditScoreList.get(c).getRiskScore());
					System.out.println("@ScoreName : " + creditScoreList.get(c).getScoreName());
					System.out.println("@PopulationRank : " + creditScoreList.get(c).getPopulationRank());
					System.out.println("=================CreditScoreFactor====================");
					List<CreditScoreFactor> trueLinkCreditScoreFactorList = creditScoreList.get(c)
							.getCreditScoreFactor();
					for (int f = 0; f < trueLinkCreditScoreFactorList.size(); f++) {
						System.out.println("************(" + f + "**********)");
						System.out.println("@bureauCode : " + trueLinkCreditScoreFactorList.get(f).getBureauCode());
						System.out.println("@FactorType : " + trueLinkCreditScoreFactorList.get(f).getFactorType());
						System.out.println("@Abbreviation : "
								+ trueLinkCreditScoreFactorList.get(f).getFactor().getAbbreviation());
						System.out.println(
								"@Description : " + trueLinkCreditScoreFactorList.get(f).getFactor().getDescription());
						System.out.println("@Symbol : " + trueLinkCreditScoreFactorList.get(f).getFactor().getSymbol());
						System.out.println("@Rank : " + trueLinkCreditScoreFactorList.get(f).getFactor().getRank());
						if (trueLinkCreditScoreFactorList.get(f).getFactorText() != null) {
							List<FactorText> trueLinkFactorTextList = trueLinkCreditScoreFactorList.get(f)
									.getFactorText();
							for (int t = 0; t < trueLinkFactorTextList.size(); t++) {
								System.out.println("@$ : " + trueLinkFactorTextList.get(t).get$());
							}
						}
					}
					System.out.println("=================CreditScoreModel====================");
					System.out.println(
							"@Abbreviation : " + creditScoreList.get(c).getCreditScoreModel().getAbbreviation());
					System.out
							.println("@Description : " + creditScoreList.get(c).getCreditScoreModel().getDescription());
					System.out.println("@Symbol : " + creditScoreList.get(c).getCreditScoreModel().getSymbol());
					System.out.println("@Rank : " + creditScoreList.get(c).getCreditScoreModel().getRank());
					System.out.println("=================NoScoreReason====================");
					System.out
							.println("@Abbreviation : " + creditScoreList.get(c).getNoScoreReason().getAbbreviation());
					System.out.println("@Description  : " + creditScoreList.get(c).getNoScoreReason().getDescription());
					System.out.println("@Rank : " + creditScoreList.get(c).getNoScoreReason().getRank());
					System.out.println("@Symbol : " + creditScoreList.get(c).getNoScoreReason().getSymbol());
					System.out.println("=================Source====================");
					System.out.println("@BorrowerKey : " + creditScoreList.get(c).getSource().getBorrowerKey());
					System.out.println("=================Bureau====================");
					System.out.println(
							"@Abbreviation : " + creditScoreList.get(c).getSource().getBureau().getAbbreviation());
					System.out.println(
							"@Description : " + creditScoreList.get(c).getSource().getBureau().getDescription());
					System.out.println("@Rank  : " + creditScoreList.get(c).getSource().getBureau().getRank());
					System.out.println("@Symbol : " + creditScoreList.get(c).getSource().getBureau().getSymbol());
					System.out.println("=================InquiryDate====================");
					System.out.println("@$ : " + creditScoreList.get(c).getSource().getInquiryDate());
					System.out.println("=================Reference====================");
					if (creditScoreList.get(c).getSource().getReference() != null)
						System.out.println("@$ : " + creditScoreList.get(c).getSource().getReference());
				}
				
				System.out.println("*************************************************");
				System.out.println("=================Employer====================");
				int count=0;
				List<Employer> employer = trueLink.getBorrower().getEmployer();
				for (Employer employer2 : employer) {
					System.out.println("*************("+count+++")*************");
					System.out.println("@DateReported : " + employer2.getDateReported());
					System.out.println("@dateUpdated : " + employer2.getDateUpdated());
					System.out.println("@name : " + employer2.getName());
					System.out.println("@partitionSet : " + employer2.getPartitionSet());
					System.out.println("=================CreditAddress====================");
					CreditAddress creditAddress = employer2.getCreditAddress();
					System.out.println("@city : " + creditAddress.getCity());
					System.out.println("@stateCode : " + creditAddress.getStateCode());
					System.out.println("@unparsedStreet : " + creditAddress.getUnparsedStreet());
					System.out.println("@postalCode : " + creditAddress.getPostalCode());
					System.out.println("=================Source====================");
					System.out.println("@BorrowerKey : " + employer2.getSource().getBorrowerKey());
					System.out.println("=================Bureau====================");
					Bureau bureaus = employer2.getSource().getBureau();
					System.out.println("@Abbreviation : " + bureaus.getAbbreviation());
					System.out.println("@Description : " + bureaus.getDescription());
					System.out.println("@Rank  : " + bureaus.getRank());
					System.out.println("@Symbol : " + bureaus.getSymbol());
					System.out.println("=================InquiryDate====================");
					if(employer2.getSource().getInquiryDate()!=null) {
					System.out.println("@$ : " + employer2.getSource().getInquiryDate().get$());}
					System.out.println("=================Reference====================");
					if (employer2.getSource().getReference() != null)
						System.out.println("@$ : " + employer2.getSource().getReference().get$());
				}
				System.out.println("=================PreviousAddress====================");
				List<PreviousAddress> previousAddresseList = trueLink.getBorrower().getPreviousAddress();
				for (int p = 0; p < previousAddresseList.size(); p++) {
					System.out.println("@dateReported : " + previousAddresseList.get(p).getDateReported());
					System.out.println("@addressOrder : " + previousAddresseList.get(p).getAddressOrder());
					System.out.println("@partitionSet : " + previousAddresseList.get(p).getPartitionSet());
					CreditAddress address = previousAddresseList.get(p).getCreditAddress();
					System.out.println("@city : " + address.getCity());
					System.out.println("@direction : " + address.getDirection());
					System.out.println("@houseNumber : " + address.getHouseNumber());
					System.out.println("@postDirection : " + address.getPostDirection());
					System.out.println("@stateCode : " + address.getStateCode());
					System.out.println("@streetName : " + address.getStreetName());
					System.out.println("@streetType : " + address.getStreetType());
					System.out.println("@unit : " + address.getUnit());
					System.out.println("@postalCode : " + address.getPostalCode());
					System.out.println("================Dwelling=====================");
					System.out
							.println("@Abbreviation : " + previousAddresseList.get(p).getDwelling().getAbbreviation());
					System.out.println("@Description : " + previousAddresseList.get(p).getDwelling().getDescription());
					System.out.println("@Symbol  : " + previousAddresseList.get(p).getDwelling().getSymbol());
					System.out.println("@Rank : " + previousAddresseList.get(p).getDwelling().getRank());
					System.out.println("=================Origin====================");
					System.out.println("@Abbreviation : " + previousAddresseList.get(p).getOrigin().getAbbreviation());
					System.out.println("@Description : " + previousAddresseList.get(p).getOrigin().getDescription());
					System.out.println("@Symbol  : " + previousAddresseList.get(p).getOrigin().getSymbol());
					System.out.println("@Rank : " + previousAddresseList.get(p).getOrigin().getRank());
					System.out.println("=================Ownership====================");
					System.out
							.println("@Abbreviation : " + previousAddresseList.get(p).getOwnership().getAbbreviation());
					System.out.println("@Description : " + previousAddresseList.get(p).getOwnership().getDescription());
					System.out.println("@Symbol  : " + previousAddresseList.get(p).getOwnership().getSymbol());
					System.out.println("@Rank : " + previousAddresseList.get(p).getOwnership().getRank());
					System.out.println("=================Source====================");
					System.out.println("@BorrowerKey : " + previousAddresseList.get(p).getSource().getBorrowerKey());
					System.out.println("=================Bureau====================");
					System.out.println(
							"@Abbreviation : " + previousAddresseList.get(p).getSource().getBureau().getAbbreviation());
					System.out.println(
							"@Description : " + previousAddresseList.get(p).getSource().getBureau().getDescription());
					System.out.println("@Symbol  : " + previousAddresseList.get(p).getSource().getBureau().getSymbol());
					System.out.println("@Rank : " + previousAddresseList.get(p).getSource().getBureau().getRank());
					System.out.println("=================InquiryDate====================");
					System.out.println("@$ : " + previousAddresseList.get(p).getSource().getInquiryDate());
					System.out.println("=================Reference====================");
					if (previousAddresseList.get(p).getSource().getReference() != null)
						System.out.println("@$ : " + previousAddresseList.get(p).getSource().getReference());
				}
				if (bundleComponentsList.get(i).getTrueLinkCreditReportType().getBorrower()
						.getSocialPartition() != null) {
					System.out.println("=================SocialPartition====================");
					List<Social> socialList = trueLink.getBorrower().getSocialPartition().getSocial();
					for (int s = 0; s < socialList.size(); s++) {
						if(socialList.get(s).getSocialSecurityNumber()!=null) {
						System.out.println(
								"SocialSecurityNumber : " + socialList.get(s).getSocialSecurityNumber().get$());}
						System.out.println("@BorrowerKey : " + socialList.get(s).getSource().getBorrowerKey());
						System.out.println("=================Bureau====================");
						System.out.println(
								"@Abbreviation : " + socialList.get(s).getSource().getBureau().getAbbreviation());
						System.out.println(
								"@Description : " + socialList.get(s).getSource().getBureau().getDescription());
						System.out.println("@Symbol  : " + socialList.get(s).getSource().getBureau().getSymbol());
						System.out.println("@Rank : " + socialList.get(s).getSource().getBureau().getRank());
						System.out.println("=================InquiryDate====================");
						if(socialList.get(s).getSource().getInquiryDate()!=null)
						System.out.println("@$ : " + socialList.get(s).getSource().getInquiryDate().get$());
						System.out.println("=================Reference====================");
						if (socialList.get(s).getSource().getReference() != null)
							System.out.println("@$ : " + socialList.get(s).getSource().getReference().get$());
					}
					System.out.println("=================InquiryPartition====================");
					List<InquiryPartition> inquiryPartitionList = trueLink.getInquiryPartition();
					for (int q = 0; q < inquiryPartitionList.size(); q++) {
						System.out.println("*************inquiry : (" + q + ")**************");
						Inquiry inquiry = inquiryPartitionList.get(q).getInquiry();
						System.out.println("@inquiryDate : " + inquiry.getInquiryDate());
						System.out.println("@subscriberName : " + inquiry.getSubscriberName());
						System.out.println("@subscriberNumber : " + inquiry.getSubscriberNumber());
						System.out.println("@bureau : " + inquiry.getBureau());
						System.out.println("@inquiryType : " + inquiry.getInquiryType());
						IndustryCode industryCode = inquiryPartitionList.get(q).getInquiry().getIndustryCode();
						System.out.println("@Abbreviation : " + industryCode.getAbbreviation());
						System.out.println("@Description : " + industryCode.getDescription());
						System.out.println("@Symbol  : " + industryCode.getSymbol());
						System.out.println("@Rank : " + industryCode.getRank());
						if (inquiry.getInquiryHashComplex() != null || inquiry.getInquiryHashSimple() != null) {
							System.out.println("@$ : " + inquiry.getInquiryHashComplex().get$());
							System.out.println("@$ : " + inquiry.getInquiryHashSimple().get$());
						}
						Source source = inquiry.getSource();
						System.out.println("@BorrowerKey : " + source.getBorrowerKey());
						Bureau bureau = source.getBureau();
						System.out.println("@Abbreviation : " + bureau.getAbbreviation());
						System.out.println("@Description : " + bureau.getDescription());
						System.out.println("@Rank  : " + bureau.getRank());
						System.out.println("@Symbol : " + bureau.getSymbol());
						if(source.getInquiryDate()!=null)
						System.out.println("@$ : " + source.getInquiryDate().get$());
						if (source.getReference() != null)
							System.out.println("@$ : " + source.getReference().get$());
					}
					if (trueLink.getMessage() != null) {
						System.out.println("=================Message====================");
						System.out.println("@Text : " + trueLink.getMessage().getText());
						System.out.println("--------------getCode---------------");
						Code msg = trueLink.getMessage().getCode();
						System.out.println("@Abbreviation : " + msg.getAbbreviation());
						System.out.println("@Description : " + msg.getDescription());
						System.out.println("@Symbol  : " + msg.getSymbol());
						System.out.println("@Rank : " + msg.getRank());

						System.out.println("--------------getType---------------");
						System.out.println("@Text : " + trueLink.getMessage().getType());
						msg = trueLink.getMessage().getCode();
						System.out.println("@Abbreviation : " + msg.getAbbreviation());
						System.out.println("@Description : " + msg.getDescription());
						System.out.println("@Symbol  : " + msg.getSymbol());
						System.out.println("@Rank : " + msg.getRank());
					}
					System.out.println("=================SafetyCheckPassed====================");
					if(trueLink.getSafetyCheckPassed()!=null)
					System.out.println(trueLink.getSafetyCheckPassed().get$());
					System.out.println("============SB168Frozen=============");
					SB68Frozen frozen = trueLink.getsB68Frozen();
					System.out.println("@equifax : " + frozen.getEquifax());
					System.out.println("@experian : " + frozen.getExperian());
					System.out.println("@transunion : " + frozen.getTransunion());
					List<Source> sourceList = trueLink.getSources().getSource();
					for (int s = 0; s < sourceList.size(); s++) {
						System.out.println("*************Sources : (" + s + ")**************");
						System.out.println("@Abbreviation : " + sourceList.get(s).getBureau().getAbbreviation());
						System.out.println("@Description : " + sourceList.get(s).getBureau().getDescription());
						System.out.println("@Symbol : " + sourceList.get(s).getBureau().getSymbol());
						System.out.println("@Rank : " + sourceList.get(s).getBureau().getRank());
						if(socialList.get(s).getSource().getInquiryDate()!=null)
						System.out.println("$ : " + socialList.get(s).getSource().getInquiryDate().get$());
						if(sourceList.get(s).getOriginalData()!=null)
						System.out.println("$ : " + sourceList.get(s).getOriginalData().get$());
					}
					List<Subscriber> subscriberList = trueLink.getSubscriber();
					for (int sb = 0; sb < subscriberList.size(); sb++) {
						System.out.println("*************Subscriber : (" + sb + ")**************");
						System.out.println("@name : " + subscriberList.get(sb).getName());
						System.out.println("@telephone : " + subscriberList.get(sb).getTelephone());
						System.out.println("@subscriberCode : " + subscriberList.get(sb).getSubscriberCode());
						System.out.println("@city : " + subscriberList.get(sb).getCreditAddress().getCity());
						System.out.println("@stateCode : " + subscriberList.get(sb).getCreditAddress().getStateCode());
						System.out.println(
								"@unparsedStreet : " + subscriberList.get(sb).getCreditAddress().getUnparsedStreet());
						System.out.println("@postalCode : " + subscriberList.get(sb).getCreditAddress().getPostalCode());
						IndustryCode industryCode = subscriberList.get(sb).getIndustryCode();
						System.out.println("@Abbreviation : " + industryCode.getAbbreviation());
						System.out.println("@Description : " + industryCode.getDescription());
						System.out.println("@Symbol  : " + industryCode.getSymbol());
						System.out.println("@Rank : " + industryCode.getRank());
						System.out.println("=================Source====================");
						System.out.println("@BorrowerKey : " + subscriberList.get(sb).getSource().getBorrowerKey());
						System.out.println("=================Bureau====================");
						System.out.println(
								"@Abbreviation : " + subscriberList.get(sb).getSource().getBureau().getAbbreviation());
						System.out.println(
								"@Description : " + subscriberList.get(sb).getSource().getBureau().getDescription());
						System.out.println("@Symbol  : " + subscriberList.get(sb).getSource().getBureau().getSymbol());
						System.out.println("@Rank : " + subscriberList.get(sb).getSource().getBureau().getRank());
						if(subscriberList.get(sb).getSource().getInquiryDate()!=null)
						System.out.println("@$ : " + subscriberList.get(sb).getSource().getInquiryDate().get$());
						if (subscriberList.get(sb).getSource().getReference() != null)
							System.out.println("@$ : " + subscriberList.get(sb).getSource().getReference().get$());
					}
					System.out.println("=================Summary====================");
					System.out.println("---------------InquirySummary-----------------");
					Summary summary = trueLink.getSummary();
					System.out.println("@NumberInLastYears : "
							+ summary.getInquirySummary().getInquiryEquifax().getNumberInLastYears());
					System.out.println("@NumberInLastYears : "
							+ summary.getInquirySummary().getInquiryExperian().getNumberInLastYears());
					System.out.println("@NumberInLastYears : "
							+ summary.getInquirySummary().getInquiryMerge().getNumberInLastYears());
					System.out.println("@NumberInLastYears : "
							+ summary.getInquirySummary().getInquiryTransUnion().getNumberInLastYears());
					System.out.println("---------------PublicRecordSummary-----------------");
					System.out.println("@NumberOfRecords : "
							+ summary.getPublicRecordSummary().getPublicRecordSummaryEquifax().getNumberOfRecords());
					System.out.println("@NumberOfRecords : "
							+ summary.getPublicRecordSummary().getPublicRecordSummaryExperian().getNumberOfRecords());
					System.out.println("@NumberOfRecords : "
							+ summary.getPublicRecordSummary().getPublicRecordSummaryMerge().getNumberOfRecords());
					System.out.println("@NumberOfRecords : "
							+ summary.getPublicRecordSummary().getPublicRecordSummaryTransUnion().getNumberOfRecords());
					System.out.println("---------------TradelineSummary-----------------");
					System.out.println("---------------TradelineEquifax-----------------");
					TradelineSummaryEquifax tradelineSummaryEquifax = summary.getTradelineSummary()
							.getTradelineSummaryEquifax();
					System.out.println("@TotalAccounts : " + tradelineSummaryEquifax.getTotalAccounts());
					System.out.println("@OpenAccounts : " + tradelineSummaryEquifax.getOpenAccounts());
					System.out.println("@CloseAccounts : " + tradelineSummaryEquifax.getCloseAccounts());
					System.out.println("@DelinquentAccounts : " + tradelineSummaryEquifax.getDelinquentAccounts());
					System.out.println("@DerogatoryAccounts : " + tradelineSummaryEquifax.getDerogatoryAccounts());
					System.out.println("@TotalBalance : " + tradelineSummaryEquifax.getTotalBalances());
					System.out.println("@TotalMonthlyPayments : " + tradelineSummaryEquifax.getTotalMonthlyPayments());
					System.out.println("**********TradelineExperian**********");
					TradelineSummaryExperian tradelineSummaryExperian = summary.getTradelineSummary()
							.getTradelineSummaryExperian();
					System.out.println("@TotalAccounts : " + tradelineSummaryExperian.getTotalAccounts());
					System.out.println("@OpenAccounts" + tradelineSummaryExperian.getOpenAccounts());
					System.out.println("@CloseAccounts : " + tradelineSummaryExperian.getCloseAccounts());
					System.out.println("@DelinquentAccounts : " + tradelineSummaryExperian.getDelinquentAccounts());
					System.out.println("@DerogatoryAccounts : " + tradelineSummaryExperian.getDerogatoryAccounts());
					System.out.println("@TotalAccounts : " + tradelineSummaryExperian.getTotalAccounts());
					System.out.println("@TotalMonthlyPayments : " + tradelineSummaryExperian.getTotalMonthlyPayments());
					System.out.println("**********TradelineMerge**********");
					TradelineSummaryMerge tradelineSummaryMerge = summary.getTradelineSummary()
							.getTradelineSummaryMerge();
					System.out.println("@TotalAccounts : " + tradelineSummaryMerge.getTotalAccounts());
					System.out.println("@OpenAccounts" + tradelineSummaryMerge.getOpenAccounts());
					System.out.println("@CloseAccounts : " + tradelineSummaryMerge.getCloseAccounts());
					System.out.println("@DelinquentAccounts : " + tradelineSummaryMerge.getDelinquentAccounts());
					System.out.println("@DerogatoryAccounts : " + tradelineSummaryMerge.getDerogatoryAccounts());
					System.out.println("@TotalAccounts : " + tradelineSummaryMerge.getTotalAccounts());
					System.out.println("@TotalMonthlyPayments : " + tradelineSummaryMerge.getTotalMonthlyPayments());
					System.out.println("**********TradelineTransUnion**********");
					TradelineSummaryTransUnion tradelineSummaryTransUnion = summary.getTradelineSummary()
							.getTradelineSummaryTransUnion();
					System.out.println("@TotalAccounts : " + tradelineSummaryTransUnion.getTotalAccounts());
					System.out.println("@OpenAccounts" + tradelineSummaryTransUnion.getOpenAccounts());
					System.out.println("@CloseAccounts : " + tradelineSummaryTransUnion.getCloseAccounts());
					System.out.println("@DelinquentAccounts : " + tradelineSummaryTransUnion.getDelinquentAccounts());
					System.out.println("@DerogatoryAccounts : " + tradelineSummaryTransUnion.getDerogatoryAccounts());
					System.out.println("@TotalAccounts : " + tradelineSummaryTransUnion.getTotalAccounts());
					System.out
							.println("@TotalMonthlyPayments : " + tradelineSummaryTransUnion.getTotalMonthlyPayments());
					
					System.out.println();
					System.out.println("=================TradeLinePartition====================");
					List<TradeLinePartition> tradeLinePartitionList = trueLink.getTradeLinePartition();
					for (int t = 0; t < tradeLinePartitionList.size(); t++) {
						System.out.println("***********TradeLinePartition =: (" + t + ")**************");
						System.out.println("@accountTypeDescription : "
								+ tradeLinePartitionList.get(t).getAccountTypeDescription());
						System.out.println(
								"@accountTypeSymbol : " + tradeLinePartitionList.get(t).getAccountTypeSymbol());
						System.out.println("@accountTypeAbbreviation : "
								+ tradeLinePartitionList.get(t).getAccountTypeAbbreviation());
						
						List<Tradeline> tradelineList = tradeLinePartitionList.get(t).getTradeline();
						for (int l = 0; l < tradelineList.size(); l++) {
							System.out.println();
							System.out.println("***********TRADELINE =: (" + l + ")**************");
							System.out.println();
							Tradeline tradeLine = tradelineList.get(l);
							System.out.println("@subscriberCode : " + tradeLine.getSubscriberCode());
							System.out.println("@highBalance : " + tradeLine.getHighBalance());
							System.out.println("@dateVerified : " + tradeLine.getDateVerified());
							System.out.println("@dateReported : " + tradeLine.getDateReported());
							System.out.println("@dateOpened : " + tradeLine.getDateOpened());
							System.out.println("@accountNumber : " + tradeLine.getAccountNumber());
							System.out.println("@dateAccountStatus : " + tradeLine.getDateAccountStatus());
							System.out.println("@currentBalance : " + tradeLine.getCurrentBalance());
							System.out.println("@creditorName : " + tradeLine.getCreditorName());
							System.out.println("@position : " + tradeLine.getPosition());
							System.out.println("@bureau : " + tradeLine.getBureau());
							System.out.println("---------------AccountCondition-----------------");
							System.out.println("@abbreviation : " + tradeLine.getAccountCondition().getAbbreviation());
							System.out.println("@description : " + tradeLine.getAccountCondition().getDescription());
							System.out.println("@symbol : " + tradeLine.getAccountCondition().getSymbol());
							System.out.println("@rank : " + tradeLine.getAccountCondition().getRank());
							System.out.println("---------------AccountDesignator-----------------");
							System.out.println("@abbreviation : " + tradeLine.getAccountDesignator().getAbbreviation());
							System.out.println("@description : " + tradeLine.getAccountDesignator().getDescription());
							System.out.println("@symbol : " + tradeLine.getAccountDesignator().getSymbol());
							System.out.println("@rank : " + tradeLine.getAccountDesignator().getRank());
							if (tradeLine.getCollectionTrade() != null) {
								System.out.println("---------------CollectionTrade-----------------");
								System.out.println(
										"@originalCreditor : " + tradeLine.getCollectionTrade().getOriginalCreditor());
								System.out.println("@abbreviation : "
										+ tradeLine.getCollectionTrade().getCreditType().getAbbreviation());
								System.out.println("@description : "
										+ tradeLine.getCollectionTrade().getCreditType().getDescription());
								System.out.println(
										"@symbol : " + tradeLine.getCollectionTrade().getCreditType().getSymbol());
								System.out
										.println("@rank : " + tradeLine.getCollectionTrade().getCreditType().getRank());
							}
							System.out.println("---------------DisputeFlag-----------------");
							System.out.println("@abbreviation : " + tradeLine.getDisputeFlag().getAbbreviation());
							System.out.println("@description : " + tradeLine.getDisputeFlag().getDescription());
							System.out.println("@symbol : " + tradeLine.getDisputeFlag().getSymbol());
							System.out.println("@rank : " + tradeLine.getDisputeFlag().getRank());
							System.out.println("---------------GrantedTrade-----------------");
							
							GrantedTrade grantedTrade = tradeLine.getGrantedTrade();
							if(tradeLine.getGrantedTrade()!=null) {
							System.out.println("@monthsReviewed : "+grantedTrade.getMonthsReviewed());
							System.out.println("@monthlyPayment : " + grantedTrade.getMonthlyPayment());
							System.out.println("@late90Count : " + grantedTrade.getLate90Count());
							System.out.println("@late60Count : " + grantedTrade.getLate60Count());
							System.out.println("@late30Count : " + grantedTrade.getLate30Count());
							System.out.println("@dateLastPayment : " + grantedTrade.getDateLastPayment());
							System.out.println("@termMonths : " + grantedTrade.getTermMonths());
							System.out.println("@collateral : " + grantedTrade.getCollateral());
							System.out.println("@amountPastDue : " + grantedTrade.getAmountPastDue());
							System.out.println("@worstPatStatusCount : " + grantedTrade.getWorstPatStatusCount());

							System.out.println("@abbreviation : " + grantedTrade.getAccountType().getAbbreviation());
							System.out.println("@description : " + grantedTrade.getAccountType().getDescription());
							System.out.println("@symbol : " + grantedTrade.getAccountType().getSymbol());
							System.out.println("@rank : " + grantedTrade.getAccountType().getRank());
							if(grantedTrade.getCreditLimit()!=null)
							System.out.println("@$ : " + grantedTrade.getCreditLimit().get$());
							System.out.println("@abbreviation : " + grantedTrade.getCreditType().getAbbreviation());
							System.out.println("@description : " + grantedTrade.getCreditType().getDescription());
							System.out.println("@symbol : " + grantedTrade.getCreditType().getSymbol());
							System.out.println("@rank : " + grantedTrade.getCreditType().getRank());
							System.out
									.println("@abbreviation : " + grantedTrade.getPaymentFrequency().getAbbreviation());
							System.out.println("@description : " + grantedTrade.getPaymentFrequency().getDescription());
							System.out.println("@symbol : " + grantedTrade.getPaymentFrequency().getSymbol());
							System.out.println("@rank : " + grantedTrade.getPaymentFrequency().getRank());
							PaymentStatusHistory paymentStatusHistory=grantedTrade.getPayStatusHistory();
							if(paymentStatusHistory!=null) {
							System.out.println("status : " + paymentStatusHistory.getStatus());
							System.out.println("status : " + paymentStatusHistory.getStartDate());
							
							List<MonthlyPayStatus> monthlyPayStatusList =grantedTrade.getPayStatusHistory().getMonthlyPayStatus();
							for(MonthlyPayStatus monthlyPayStatus: monthlyPayStatusList)
							{
								System.out.println("@date : "+monthlyPayStatus.getDate());
								System.out.println("@status : "+monthlyPayStatus.getStatus());
							}
							}
							if(grantedTrade.getCreditLimit()!=null)
							System.out.println("@$ : " + grantedTrade.getCreditLimit().get$());
							System.out.println("@abbreviation : " + grantedTrade.getTermType().getAbbreviation());
							System.out.println("@description : " + grantedTrade.getTermType().getDescription());
							System.out.println("@symbol : " + grantedTrade.getTermType().getSymbol());
							System.out.println("@rank : " + grantedTrade.getTermType().getRank());
							System.out.println("@abbreviation : " + grantedTrade.getWorstPayStatus().getAbbreviation());
							System.out.println("@description : " + grantedTrade.getWorstPayStatus().getDescription());
							System.out.println("@symbol : " + grantedTrade.getWorstPayStatus().getSymbol());
							System.out.println("@rank : " + grantedTrade.getWorstPayStatus().getRank());}
							System.out.println("---------------IndustryCode-----------------");
							System.out.println("@abbreviation : " + tradeLine.getIndustryCode().getAbbreviation());
							System.out.println("@description : " + tradeLine.getIndustryCode().getDescription());
							System.out.println("@symbol : " + tradeLine.getIndustryCode().getSymbol());
							System.out.println("@rank : " + tradeLine.getIndustryCode().getRank());
							System.out.println("---------------OpenClosed-----------------");
							System.out.println("@abbreviation : " + tradeLine.getOpenClosed().getAbbreviation());
							System.out.println("@description : " + tradeLine.getOpenClosed().getDescription());
							System.out.println("@symbol : " + tradeLine.getOpenClosed().getSymbol());
							System.out.println("@rank : " + tradeLine.getOpenClosed().getRank());
							System.out.println("---------------PayStatus-----------------");
							System.out.println("@abbreviation : " + tradeLine.getPayStatus().getAbbreviation());
							System.out.println("@description : " + tradeLine.getPayStatus().getDescription());
							System.out.println("@symbol : " + tradeLine.getPayStatus().getSymbol());
							System.out.println("@rank : " + tradeLine.getPayStatus().getRank());
							System.out.println("---------------Remark-----------------");

							if (tradeLine.getRemark() != null) {
								List<IdentityIQ3ScoreMyScoreRemark> remarkList = tradelineList.get(l).getRemark();
								for (int r = 0; r < remarkList.size(); r++) {
									System.out.println("@customRemark : " + remarkList.get(r).getCustomRemark());
									System.out.println(
											"@abbreviation : " + remarkList.get(r).getRemarkCode().getAbbreviation());
									System.out.println(
											"@description : " + remarkList.get(r).getRemarkCode().getDescription());
									System.out.println("@symbol : " + remarkList.get(r).getRemarkCode().getSymbol());
									System.out.println("@rank : " + remarkList.get(r).getRemarkCode().getRank());
								}
							}
							System.out.println("---------------Source-----------------");
							System.out.println("@BorrowerKey : " + tradeLine.getSource().getBorrowerKey());
							System.out
									.println("@Abbreviation : " + tradeLine.getSource().getBureau().getAbbreviation());
							System.out.println("@Description : " + tradeLine.getSource().getBureau().getDescription());
							System.out.println("@Symbol  : " + tradeLine.getSource().getBureau().getSymbol());
							System.out.println("@Rank : " + tradeLine.getSource().getBureau().getRank());
							if(tradeLine.getSource().getInquiryDate()!=null)
							System.out.println("@$ : " + tradeLine.getSource().getInquiryDate().get$());
							if(tradeLine.getSource().getReference()!=null)
							System.out.println("@$ : " + tradeLine.getSource().getReference().get$());
							System.out.println("---------------TradelineHashComplex-----------------");
							if(tradeLine.getTradelineHashComplex()!=null) {
							System.out.println("@$ : " + tradeLine.getTradelineHashComplex().get$());
							System.out.println("---------------TradelineHashSimple-----------------");
							System.out.println("@$ : " + tradeLine.getTradelineHashSimple().get$());}
							System.out.println("---------------ArrayAccountIdentifier-----------------");
							if(tradeLine.getArrayAccountIdentifier()!=null)
							System.out.println("@$ : " + tradeLine.getArrayAccountIdentifier().get$());
							if (tradeLine.getTUIHandle() != null) {
								System.out.println("---------------TUI_Handle-----------------");
								System.out.println("@$ : " + tradeLine.getTUIHandle().get$());
							}
							System.out.println("---------------VerificationIndicator-----------------");
							System.out.println(
									"@abbreviation : " + tradeLine.getVerificationIndicator().getAbbreviation());
							System.out
									.println("@description : " + tradeLine.getVerificationIndicator().getDescription());
							System.out.println("@symbol : " + tradeLine.getVerificationIndicator().getSymbol());
							System.out.println("@rank : " + tradeLine.getVerificationIndicator().getRank());
						}
					}
					System.out.println("$ : " + bundleComponentObj.getType());

				}
			} else
				System.out.println("@$ : " + bundleComponentObj.getType());
		}
	}
}
