package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi extends AbstractUiTemplate {
    
    private SelectTeamUi selectTeamUi;

    public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
        this.selectTeamUi = selectTeamUi;
    }

    protected void showMenu() {
        System.out.println("------------------");
        System.out.println("");
        System.out.println("1.종료");
        System.out.println("2.팀 전체 리스트");
        System.out.println("");
        System.out.println("번호를 입력하고 Enter를 눌러 주십시오.");
    }

    protected int getMaxMenuNumber() {
        return 2;
    }

    protected int getMinMenuNumber() {
        return 1;
    }
    
    protected void execute(int number) {
        switch (number) {
        case 1:
            //1.종료
            System.out.println("프로그램이 종료도었습니다.");
            System.exit(0);
        case 2:
            //2.팀 전체 리스트
            this.selectTeamUi.show();
            break;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        //스프링 설정 파일을 읽어 들임
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenuUi menuUi = (MenuUi)context.getBean("menuUi");
        while (true) {
            menuUi.show();
        }

    }

}
