package ua.external.spring.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ua.external.spring.service.IEmailService;
import ua.external.spring.util.EmailContent;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private JavaMailSender sender;

    final static Logger logger = LogManager.getLogger();

    @Override
    public void send(String sendTo, String subject, String messageToSend) {
        try {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            String htmlMsg = "<!DOCTYPE html><html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\"><head>  <title></title>  <!--[if !mso]><!-- -->  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">  <!--<![endif]--><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><style type=\"text/css\">  #outlook a { padding: 0; }  .ReadMsgBody { width: 100%; }  .ExternalClass { width: 100%; }  .ExternalClass * { line-height:100%; }  body { margin: 0; padding: 0; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; }  table, td { border-collapse:collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; }  img { border: 0; height: auto; line-height: 100%; outline: none; text-decoration: none; -ms-interpolation-mode: bicubic; }  p { display: block; margin: 13px 0; }</style><!--[if !mso]><!--><style type=\"text/css\">  @media only screen and (max-width:480px) {    @-ms-viewport { width:320px; }    @viewport { width:320px; }  }</style><!--<![endif]--><!--[if mso]><xml>  <o:OfficeDocumentSettings>    <o:AllowPNG/>    <o:PixelsPerInch>96</o:PixelsPerInch>  </o:OfficeDocumentSettings></xml><![endif]--><!--[if lte mso 11]><style type=\"text/css\">  .outlook-group-fix {    width:100% !important;  }</style><![endif]--><!--[if !mso]><!-->    <link href=\"https://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700\" rel=\"stylesheet\" type=\"text/css\">    <style type=\"text/css\">        @import url(https://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700);    </style>  <!--<![endif]--><style type=\"text/css\">  @media only screen and (min-width:480px) {    .mj-column-per-100 { width:100%!important; }  }</style></head><body style=\"background: #EDE8DA;\">    <div class=\"mj-container\" style=\"background-color:#EDE8DA;\"><!--[if mso | IE]>      <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">        <tr>          <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">      <![endif]--><div style=\"margin:0px auto;max-width:600px;\"><table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;\" align=\"center\" border=\"0\"><tbody><tr><td style=\"text-align:center;vertical-align:top;direction:ltr;font-size:0px;padding:9px 0px 9px 0px;\"><!--[if mso | IE]>      <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">        <tr>          <td style=\"vertical-align:top;width:600px;\">      <![endif]--><div class=\"mj-column-per-100 outlook-group-fix\" style=\"vertical-align:top;display:inline-block;direction:ltr;font-size:13px;text-align:left;width:100%;\"><table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"vertical-align:top;\" width=\"100%\" border=\"0\"><tbody><tr><td style=\"word-wrap:break-word;font-size:0px;padding:10px 10px 10px 10px;\" align=\"center\"><div style=\"cursor:auto;color:#161515;font-family:Bitter, Georgia, serif;font-size:11px;line-height:1.5;text-align:center;\"><h1 style=\"font-family: &apos;Cabin&apos;, sans-serif; line-height: 100%;\">Welcome to TOKANclothes</h1></div></td></tr></tbody></table></div><!--[if mso | IE]>      </td></tr></table>      <![endif]--></td></tr></tbody></table></div><!--[if mso | IE]>      </td></tr></table>      <![endif]-->      <!--[if mso | IE]>      <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" align=\"center\" style=\"width:600px;\">        <tr>          <td style=\"line-height:0px;font-size:0px;mso-line-height-rule:exactly;\">      <![endif]--><div style=\"margin:0px auto;max-width:600px;background:url(./images/1562701640.jpg) top center / auto repeat;\"><!--[if mso | IE]>      <v:rect xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"true\" stroke=\"false\" style=\"width:600px;\">        <v:fill origin=\"0.5, 0\" position=\"0.5,0\" type=\"tile\" src=\"https://topolio.s3.eu-west-1.amazonaws.com/uploads/5d24ef36e3a3a/1562701640.jpg\" />        <v:textbox style=\"mso-fit-shape-to-text:true\" inset=\"0,0,0,0\">      <![endif]--><table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"font-size:0px;width:100%;background:url(https://topolio.s3.eu-west-1.amazonaws.com/uploads/5d24ef36e3a3a/1562701640.jpg) top center / auto repeat;\" align=\"center\" border=\"0\" background=\"https://topolio.s3.eu-west-1.amazonaws.com/uploads/5d24ef36e3a3a/1562701640.jpg\"><tbody><tr><td style=\"text-align:center;vertical-align:top;direction:ltr;font-size:0px;padding:5px 0px 5px 0px;\"><!--[if mso | IE]>      <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">        <tr>          <td style=\"vertical-align:top;width:600px;\">      <![endif]--><div class=\"mj-column-per-100 outlook-group-fix\" style=\"vertical-align:top;display:inline-block;direction:ltr;font-size:13px;text-align:left;width:100%;\"><table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\"><tbody><tr><td style=\"word-wrap:break-word;font-size:0px;\"><div style=\"font-size:1px;line-height:50px;white-space:nowrap;\">&#xA0;</div></td></tr><tr><td style=\"word-wrap:break-word;font-size:0px;\"><div style=\"font-size:1px;line-height:50px;white-space:nowrap;\">&#xA0;</div></td></tr><tr><td style=\"word-wrap:break-word;font-size:0px;\"><div style=\"font-size:1px;line-height:50px;white-space:nowrap;\">&#xA0;</div></td></tr><tr><td style=\"word-wrap:break-word;font-size:0px;\"><div style=\"font-size:1px;line-height:50px;white-space:nowrap;\">&#xA0;</div></td></tr><tr><td style=\"word-wrap:break-word;font-size:0px;\"><div style=\"font-size:1px;line-height:50px;white-space:nowrap;\">&#xA0;</div></td></tr><tr><td style=\"word-wrap:break-word;font-size:0px;\"><div style=\"font-size:1px;line-height:50px;white-space:nowrap;\">&#xA0;</div></td></tr><tr><td style=\"word-wrap:break-word;font-size:0px;\"><div style=\"font-size:1px;line-height:50px;white-space:nowrap;\">&#xA0;</div></td></tr><tr><td style=\"word-wrap:break-word;font-size:0px;padding:25px 24px 25px 25px;\" align=\"left\"><table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:separate;width:auto;\" align=\"left\" border=\"0\"><tbody><tr><td style=\"border:0px solid #000;border-radius:12px;color:#fff;cursor:auto;padding:16px 48px;\" align=\"center\" valign=\"middle\" bgcolor=\"#FC7CA0\"><a href=\"https://online-store-tokan.herokuapp.com/products\" style=\"text-decoration:none;background:#FC7CA0;color:#fff;font-family:Ubuntu, Helvetica, Arial, sans-serif, Helvetica, Arial, sans-serif;font-size:24px;font-weight:normal;line-height:120%;text-transform:none;margin:0px;\" target=\"_blank\">new arrivals</a></td></tr></tbody></table></td></tr><tr><td style=\"word-wrap:break-word;font-size:0px;\"><div style=\"font-size:1px;line-height:50px;white-space:nowrap;\">&#xA0;</div></td></tr><tr><td style=\"word-wrap:break-word;font-size:0px;\"><div style=\"font-size:1px;line-height:50px;white-space:nowrap;\">&#xA0;</div></td></tr><tr><td style=\"word-wrap:break-word;font-size:0px;\"><div style=\"font-size:1px;line-height:50px;white-space:nowrap;\">&#xA0;</div></td></tr></tbody></table></div><!--[if mso | IE]>      </td></tr></table>      <![endif]--></td></tr></tbody></table><!--[if mso | IE]>        <p style=\"margin:0;mso-hide:all\"><o:p xmlns:o=\"urn:schemas-microsoft-com:office:office\"> </o:p></p>        </v:textbox>      </v:rect>      <![endif]--></div><!--[if mso | IE]>      </td></tr></table>      <![endif]--></div></body></html>";
            message.setContent(messageToSend, "text/html");
            helper.setTo(sendTo);
            helper.setSubject(subject);
            sender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error("Error sending email!", e);
        }
    }

    @Override
    public void sendWelcomeLetter(String sendTo) {
        send(sendTo, "Welcome to Eat&Fit", EmailContent.WELCOME_LETTER);
    }

    @Override
    public void sendWarningLetter(String sendTo) {
        send(sendTo, "Your limit reached", EmailContent.WARNING_LETTER);
    }
}
