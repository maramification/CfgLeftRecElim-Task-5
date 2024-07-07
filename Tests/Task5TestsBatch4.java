package csen1002.tests.task5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.Timeout.ThreadMode;

import csen1002.main.task5.CfgLeftRecElim;

@Timeout(value = 5, unit = TimeUnit.SECONDS, threadMode = ThreadMode.SEPARATE_THREAD)
public class Task5TestsBatch4 {

	@Test
	public void testCfgLeftRecursionElimination1() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;W;R;O;X;Z;F#b;g;p;t;w#S/gSp,SOF,tOXW,p,bSZSS,bSwW;W/wW,SF,pSO,ORRWF;R/tOR,OwWZw,wO,SZW,b,St;O/p,FWZpO;X/WWWWp,pOwWX,SwFZF,OF,RRgS,ZFX;Z/ZgFRg,ZWWb,OOtF;F/FX,FgZ,OtZ,pOpOg,wFF");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;W;R;O;X;Z;F;S';Z';F'#b;g;p;t;w#S/gSpS',tOXWS',pS',bSZSSS',bSwWS';W/wW,gSpS'F,tOXWS'F,pS'F,bSZSSS'F,bSwWS'F,pSO,ORRWF;R/tOR,OwWZw,wO,gSpS'ZW,tOXWS'ZW,pS'ZW,bSZSSS'ZW,bSwWS'ZW,b,gSpS't,tOXWS't,pS't,bSZSSS't,bSwWS't;O/p,FWZpO;X/wWWWWp,gSpS'FWWWp,tOXWS'FWWWp,pS'FWWWp,bSZSSS'FWWWp,bSwWS'FWWWp,pSOWWWp,pRRWFWWWp,FWZpORRWFWWWp,pOwWX,gSpS'wFZF,tOXWS'wFZF,pS'wFZF,bSZSSS'wFZF,bSwWS'wFZF,pF,FWZpOF,tORRgS,pwWZwRgS,FWZpOwWZwRgS,wORgS,gSpS'ZWRgS,tOXWS'ZWRgS,pS'ZWRgS,bSZSSS'ZWRgS,bSwWS'ZWRgS,bRgS,gSpS'tRgS,tOXWS'tRgS,pS'tRgS,bSZSSS'tRgS,bSwWS'tRgS,ZFX;Z/pOtFZ',FWZpOOtFZ';F/ptZF',pOpOgF',wFFF';S'/OFS',e;Z'/gFRgZ',WWbZ',e;F'/XF',gZF',WZpOtZF',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination2() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;Q;I;Y;T;U#f;p;r;s#S/r,p,sQUrY,pI;Q/rY,TrSYQ;I/TI,STY,QUs,QUpU;Y/UYQf,QUUT,YIUS,YII,SIY,YSYUT;T/QTsYr,YpS;U/TrUfT,US,UpTsT,IYYSU");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;Q;I;Y;T;U;Y';T';U'#f;p;r;s#S/r,p,sQUrY,pI;Q/rY,TrSYQ;I/TI,rTY,pTY,sQUrYTY,pITY,rYUs,TrSYQUs,rYUpU,TrSYQUpU;Y/UYQfY',rYUUTY',TrSYQUUTY',rIYY',pIYY',sQUrYIYY',pIIYY';T/rYTsYrT',UYQfY'pST',rYUUTY'pST',rIYY'pST',pIYY'pST',sQUrYIYY'pST',pIIYY'pST';U/rYTsYrT'rUfTU',rYUUTY'pST'rUfTU',rIYY'pST'rUfTU',pIYY'pST'rUfTU',sQUrYIYY'pST'rUfTU',pIIYY'pST'rUfTU',rYTsYrT'IYYSUU',rYUUTY'pST'IYYSUU',rIYY'pST'IYYSUU',pIYY'pST'IYYSUU',sQUrYIYY'pST'IYYSUU',pIIYY'pST'IYYSUU',rTYYYSUU',pTYYYSUU',sQUrYTYYYSUU',pITYYYSUU',rYUsYYSUU',rYTsYrT'rSYQUsYYSUU',rYUUTY'pST'rSYQUsYYSUU',rIYY'pST'rSYQUsYYSUU',pIYY'pST'rSYQUsYYSUU',sQUrYIYY'pST'rSYQUsYYSUU',pIIYY'pST'rSYQUsYYSUU',rYUpUYYSUU',rYTsYrT'rSYQUpUYYSUU',rYUUTY'pST'rSYQUpUYYSUU',rIYY'pST'rSYQUpUYYSUU',pIYY'pST'rSYQUpUYYSUU',sQUrYIYY'pST'rSYQUpUYYSUU',pIIYY'pST'rSYQUpUYYSUU';Y'/IUSY',IIY',SYUTY',e;T'/rSYQTsYrT',rSYQUUTY'pST',e;U'/YQfY'pST'rUfTU',SU',pTsTU',YQfY'pST'IYYSUU',YQfY'pST'rSYQUsYYSUU',YQfY'pST'rSYQUpUYYSUU',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination3() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;U;W;J;T;Q#h;j;n#S/jS,n,nJJTQ,j;U/QU,USnU,UnJ,hThQn;W/WnUSh,TWU;J/jSnS,JUT,hQQnS,TjTT,JJSQJ;T/UnSJ,jS,JWQS,hSjQ;Q/nS,UTjT,SnSW,QJ,jQ,h");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;U;W;J;T;Q;U';W';J';T';Q'#h;j;n#S/jS,n,nJJTQ,j;U/QUU',hThQnU';W/TWUW';J/jSnSJ',hQQnSJ',TjTTJ';T/QUU'nSJT',hThQnU'nSJT',jST',jSnSJ'WQST',hQQnSJ'WQST',hSjQT';Q/nSQ',hThQnU'TjTQ',jSnSWQ',nnSWQ',nJJTQnSWQ',jnSWQ',jQQ',hQ';U'/SnUU',nJU',e;W'/nUShW',e;J'/UTJ',JSQJJ',e;T'/jTTJ'WQST',e;Q'/UU'TjTQ',JQ',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination4() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;G;P;E;L;I#c;h;r;t#S/t,tSPS,cPEI;G/tLSr,SE;P/LScEE,PtP,Lr,GLES,tSc,GIhEL;E/ItItG,EGc,EhErG,t,tP;L/IhE,LPr,LtG,rEc;I/PLh,SI,LPh,tGh");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;G;P;E;L;I;P';E';L';I'#c;h;r;t#S/t,tSPS,cPEI;G/tLSr,tE,tSPSE,cPEIE;P/LScEEP',LrP',tLSrLESP',tELESP',tSPSELESP',cPEIELESP',tScP',tLSrIhELP',tEIhELP',tSPSEIhELP',cPEIEIhELP';E/ItItGE',tE',tPE';L/IhEL',rEcL';I/rEcL'ScEEP'LhI',rEcL'rP'LhI',tLSrLESP'LhI',tELESP'LhI',tSPSELESP'LhI',cPEIELESP'LhI',tScP'LhI',tLSrIhELP'LhI',tEIhELP'LhI',tSPSEIhELP'LhI',cPEIEIhELP'LhI',tII',tSPSII',cPEIII',rEcL'PhI',tGhI';P'/tPP',e;E'/GcE',hErGE',e;L'/PrL',tGL',e;I'/hEL'ScEEP'LhI',hEL'rP'LhI',hEL'PhI',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination5() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;X;O;U;N;Q;Y#b;u;w#S/SbNb,SbN,YU,u;X/SQOU,wOwXu,YNSO,QNOU,UwNN,b;O/u,OuQ,Ou,wSN,wObS,uQuU;U/bSu,SYw;N/QNu,NUbNb;Q/UbOSS,QYN,bUuU,Xw,ObYX;Y/XXSYu,UUb,bSSQw");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;X;O;U;N;Q;Y;S';O';N';Q';Y'#b;u;w#S/YUS',uS';X/YUS'QOU,uS'QOU,wOwXu,YNSO,QNOU,UwNN,b;O/uO',wSNO',wObSO',uQuUO';U/bSu,YUS'Yw,uS'Yw;N/QNuN';Q/bSubOSSQ',YUS'YwbOSSQ',uS'YwbOSSQ',bUuUQ',YUS'QOUwQ',uS'QOUwQ',wOwXuwQ',YNSOwQ',bSuwNNwQ',YUS'YwwNNwQ',uS'YwwNNwQ',bwQ',uO'bYXQ',wSNO'bYXQ',wObSO'bYXQ',uQuUO'bYXQ';Y/uS'QOUXSYuY',wOwXuXSYuY',bSubOSSQ'NOUXSYuY',uS'YwbOSSQ'NOUXSYuY',bUuUQ'NOUXSYuY',uS'QOUwQ'NOUXSYuY',wOwXuwQ'NOUXSYuY',bSuwNNwQ'NOUXSYuY',uS'YwwNNwQ'NOUXSYuY',bwQ'NOUXSYuY',uO'bYXQ'NOUXSYuY',wSNO'bYXQ'NOUXSYuY',wObSO'bYXQ'NOUXSYuY',uQuUO'bYXQ'NOUXSYuY',bSuwNNXSYuY',uS'YwwNNXSYuY',bXSYuY',bSuUbY',uS'YwUbY',bSSQwY';S'/bNbS',bNS',e;O'/uQO',uO',e;N'/UbNbN',e;Q'/YNQ',NOUwQ',e;Y'/US'QOUXSYuY',NSOXSYuY',US'YwbOSSQ'NOUXSYuY',US'QOUwQ'NOUXSYuY',NSOwQ'NOUXSYuY',US'YwwNNwQ'NOUXSYuY',US'YwwNNXSYuY',US'YwUbY',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination6() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;M;T;V;B;Y#i;k;n#S/SkV,iY,iYi,kTkYi,TVYk,SV;M/YYT,kTiMV,MB,MS,MBM;T/MTk,SM,SnS,kTnM,kS;V/kSkV,BBM,TVT;B/k,iYY,iT,Bi,kYnMk,TSk;Y/SYnVi,SiV,iBi");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;M;T;V;B;Y;S';M';T';B';Y'#i;k;n#S/iYS',iYiS',kTkYiS',TVYkS';M/YYTM',kTiMVM';T/YYTM'TkT',kTiMVM'TkT',iYS'MT',iYiS'MT',kTkYiS'MT',iYS'nST',iYiS'nST',kTkYiS'nST',kTnMT',kST';V/kSkV,BBM,YYTM'TkT'VT,kTiMVM'TkT'VT,iYS'MT'VT,iYiS'MT'VT,kTkYiS'MT'VT,iYS'nST'VT,iYiS'nST'VT,kTkYiS'nST'VT,kTnMT'VT,kST'VT;B/kB',iYYB',iTB',kYnMkB',YYTM'TkT'SkB',kTiMVM'TkT'SkB',iYS'MT'SkB',iYiS'MT'SkB',kTkYiS'MT'SkB',iYS'nST'SkB',iYiS'nST'SkB',kTkYiS'nST'SkB',kTnMT'SkB',kST'SkB';Y/iYS'YnViY',iYiS'YnViY',kTkYiS'YnViY',kTiMVM'TkT'VYkS'YnViY',iYS'MT'VYkS'YnViY',iYiS'MT'VYkS'YnViY',kTkYiS'MT'VYkS'YnViY',iYS'nST'VYkS'YnViY',iYiS'nST'VYkS'YnViY',kTkYiS'nST'VYkS'YnViY',kTnMT'VYkS'YnViY',kST'VYkS'YnViY',iYS'iVY',iYiS'iVY',kTkYiS'iVY',kTiMVM'TkT'VYkS'iVY',iYS'MT'VYkS'iVY',iYiS'MT'VYkS'iVY',kTkYiS'MT'VYkS'iVY',iYS'nST'VYkS'iVY',iYiS'nST'VYkS'iVY',kTkYiS'nST'VYkS'iVY',kTnMT'VYkS'iVY',kST'VYkS'iVY',iBiY';S'/kVS',VS',e;M'/BM',SM',BMM',e;T'/VYkS'MT',VYkS'nST',e;B'/iB',e;Y'/YTM'TkT'VYkS'YnViY',YTM'TkT'VYkS'iVY',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination7() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;J;D;Q;C;E;X#a;c;d;l;u#S/El,CDdQ,uEdC,SJD,cQ;J/lJJlQ,cS,QcSE;D/EaXD,d,uDc;Q/Ju,JCaDJ,SJJSQ,CXQED,uXD,QC;C/dC,Cu,dQC,SaCuJ,DSDa,CaCl;E/EDD,lCC,Jd,dQ,XDScJ,EXX;X/l,cSDJ,XdQS");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;J;D;Q;C;E;X;S';Q';C';E';X'#a;c;d;l;u#S/ElS',CDdQS',uEdCS',cQS';J/lJJlQ,cS,QcSE;D/EaXD,d,uDc;Q/lJJlQuQ',cSuQ',lJJlQCaDJQ',cSCaDJQ',ElS'JJSQQ',CDdQS'JJSQQ',uEdCS'JJSQQ',cQS'JJSQQ',CXQEDQ',uXDQ';C/dCC',dQCC',ElS'aCuJC',uEdCS'aCuJC',cQS'aCuJC',EaXDSDaC',dSDaC',uDcSDaC';E/lCCE',lJJlQdE',cSdE',lJJlQuQ'cSEdE',cSuQ'cSEdE',lJJlQCaDJQ'cSEdE',cSCaDJQ'cSEdE',dCC'DdQS'JJSQQ'cSEdE',dQCC'DdQS'JJSQQ'cSEdE',uEdCS'aCuJC'DdQS'JJSQQ'cSEdE',cQS'aCuJC'DdQS'JJSQQ'cSEdE',dSDaC'DdQS'JJSQQ'cSEdE',uDcSDaC'DdQS'JJSQQ'cSEdE',uEdCS'JJSQQ'cSEdE',cQS'JJSQQ'cSEdE',dCC'XQEDQ'cSEdE',dQCC'XQEDQ'cSEdE',uEdCS'aCuJC'XQEDQ'cSEdE',cQS'aCuJC'XQEDQ'cSEdE',dSDaC'XQEDQ'cSEdE',uDcSDaC'XQEDQ'cSEdE',uXDQ'cSEdE',dQE',XDScJE';X/lX',cSDJX';S'/JDS',e;Q'/cSEuQ',cSECaDJQ',CQ',e;C'/uC',DdQS'aCuJC',aClC',e;E'/DDE',lS'JJSQQ'cSEdE',lS'aCuJC'DdQS'JJSQQ'cSEdE',aXDSDaC'DdQS'JJSQQ'cSEdE',lS'aCuJC'XQEDQ'cSEdE',aXDSDaC'XQEDQ'cSEdE',XXE',e;X'/dQSX',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination8() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;P;D;E;W;T#q;t;w#S/TDDE,t,tWwED;P/TP,PTSE,EEPw,PSD;D/TTqTD,tPPq,EtS,DwS,EW,DtSD;E/PwDS,WtEtP,PStD;W/ET,WTq,tTD,DtE,TP,SwEqT;T/tWTDE,SDEtW");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;P;D;E;W;T;P';D';E';W';T'#q;t;w#S/TDDE,t,tWwED;P/TPP',EEPwP';D/TTqTDD',tPPqD',EtSD',EWD';E/TPP'wDSE',WtEtPE',TPP'StDE';W/TPP'wDSE'TW',TPP'StDE'TW',tTDW',TTqTDD'tEW',tPPqD'tEW',TPP'wDSE'tSD'tEW',TPP'StDE'tSD'tEW',TPP'wDSE'WD'tEW',TPP'StDE'WD'tEW',TPW',TDDEwEqTW',twEqTW',tWwEDwEqTW';T/tWTDET',tDEtWT',tWwEDDEtWT';P'/TSEP',SDP',e;D'/wSD',tSDD',e;E'/EPwP'wDSE',EPwP'StDE',e;W'/tEtPE'TW',TqW',tEtPE'tSD'tEW',tEtPE'WD'tEW',e;T'/DDEDEtWT',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination9() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;C;T;N;I;P;L#d;g;n;r#S/LnNP,n,d,rCrPI;C/dPnTP,rL,dNPr,LnP,SIC;T/ST,rNg,nLIP;N/CPg,dTN,NrILC;I/IN,NrP,LnST,ICLP;P/n,gPSTP,In,NT,TCST;L/LdTIn,rPnP,NSrI,TrT,TdPnT,Ln");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;C;T;N;I;P;L;N';I';L'#d;g;n;r#S/LnNP,n,d,rCrPI;C/dPnTP,rL,dNPr,LnP,LnNPIC,nIC,dIC,rCrPIIC;T/LnNPT,nT,dT,rCrPIT,rNg,nLIP;N/dPnTPPgN',rLPgN',dNPrPgN',LnPPgN',LnNPICPgN',nICPgN',dICPgN',rCrPIICPgN',dTNN';I/dPnTPPgN'rPI',rLPgN'rPI',dNPrPgN'rPI',LnPPgN'rPI',LnNPICPgN'rPI',nICPgN'rPI',dICPgN'rPI',rCrPIICPgN'rPI',dTNN'rPI',LnSTI';P/n,gPSTP,dPnTPPgN'rPI'n,rLPgN'rPI'n,dNPrPgN'rPI'n,LnPPgN'rPI'n,LnNPICPgN'rPI'n,nICPgN'rPI'n,dICPgN'rPI'n,rCrPIICPgN'rPI'n,dTNN'rPI'n,LnSTI'n,dPnTPPgN'T,rLPgN'T,dNPrPgN'T,LnPPgN'T,LnNPICPgN'T,nICPgN'T,dICPgN'T,rCrPIICPgN'T,dTNN'T,LnNPTCST,nTCST,dTCST,rCrPITCST,rNgCST,nLIPCST;L/rPnPL',dPnTPPgN'SrIL',rLPgN'SrIL',dNPrPgN'SrIL',nICPgN'SrIL',dICPgN'SrIL',rCrPIICPgN'SrIL',dTNN'SrIL',nTrTL',dTrTL',rCrPITrTL',rNgrTL',nLIPrTL',nTdPnTL',dTdPnTL',rCrPITdPnTL',rNgdPnTL',nLIPdPnTL';N'/rILCN',e;I'/NI',CLPI',e;L'/dTInL',nPPgN'SrIL',nNPICPgN'SrIL',nNPTrTL',nNPTdPnTL',nL',e", cfgLeftRecElim.toString());
	}

	@Test
	public void testCfgLeftRecursionElimination10() {
		CfgLeftRecElim cfgLeftRecElim= new CfgLeftRecElim("S;N;U;D;J;V;B#a;f;w#S/SwD,f,JDf,SwNSD,aUJS;N/NUJfN,Sw,aDaBf,NUN,Ba,wJSB;U/JSaN,fUf,SfVa,BfN;D/aSN,SBNU,w,NNNS,NwVDS;J/BS,wVNa,aB,w;V/a,fNw,NDN,fVV;B/NaBNU,Va");
		cfgLeftRecElim.eliminateLeftRecursion();
		assertEquals("S;N;U;D;J;V;B;S';N';B'#a;f;w#S/fS',JDfS',aUJSS';N/fS'wN',JDfS'wN',aUJSS'wN',aDaBfN',BaN',wJSBN';U/JSaN,fUf,fS'fVa,JDfS'fVa,aUJSS'fVa,BfN;D/aSN,fS'BNU,JDfS'BNU,aUJSS'BNU,w,fS'wN'NNS,JDfS'wN'NNS,aUJSS'wN'NNS,aDaBfN'NNS,BaN'NNS,wJSBN'NNS,fS'wN'wVDS,JDfS'wN'wVDS,aUJSS'wN'wVDS,aDaBfN'wVDS,BaN'wVDS,wJSBN'wVDS;J/BS,wVNa,aB,w;V/a,fNw,fS'wN'DN,BSDfS'wN'DN,wVNaDfS'wN'DN,aBDfS'wN'DN,wDfS'wN'DN,aUJSS'wN'DN,aDaBfN'DN,BaN'DN,wJSBN'DN,fVV;B/fS'wN'aBNUB',wVNaDfS'wN'aBNUB',aBDfS'wN'aBNUB',wDfS'wN'aBNUB',aUJSS'wN'aBNUB',aDaBfN'aBNUB',wJSBN'aBNUB',aaB',fNwaB',fS'wN'DNaB',wVNaDfS'wN'DNaB',aBDfS'wN'DNaB',wDfS'wN'DNaB',aUJSS'wN'DNaB',aDaBfN'DNaB',wJSBN'DNaB',fVVaB';S'/wDS',wNSDS',e;N'/UJfNN',UNN',e;B'/SDfS'wN'aBNUB',aN'aBNUB',SDfS'wN'DNaB',aN'DNaB',e", cfgLeftRecElim.toString());
	}

}