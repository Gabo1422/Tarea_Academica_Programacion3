﻿<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/Login.Master" AutoEventWireup="true" CodeBehind="LoginRecuperarContraseña.aspx.cs" Inherits="SquirlearnWA.RecuperarConstraseña" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">


    <div class="d-flex align-items-center justify-content-center vh-100">
      
        <div class="card shadow text-center" style="max-width: 420px; width: 100%;">
            <h2 class="fw-bold mb-3">Restablecer contraseña</h2>
            <p class="text-muted mb-4">
                Ingrese su dirección de correo electrónico. Le enviaremos un enlace para restablecer su contraseña.
            </p>
            
            <!-- Campo de usuario -->
            <div class="text-start mb-3">
                <label for="txtCorreo" class="fw-semibold">Usuario</label>
                <div class="input-group">
                    <span class="input-group-text bg-light"><i class="fa fa-user"></i></span>
                    <asp:TextBox ID="txtCorreo" runat="server" CssClass="form-control" 
                        placeholder="correo@pucp.edu.pe"></asp:TextBox>
                </div>
            </div>

            <!-- Botón -->
            <asp:Button ID="btnRestablecer" runat="server" Text="Restablecer contraseña"
                CssClass="btn btn-primary w-100 fw-semibold"
                OnClick="btnRestablecer_Click" />
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="modalVerifica" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content text-center p-4" style="border-radius: 20px;">
                <h4 class="fw-bold">Verifica tu bandeja</h4>
                <p class="text-muted">
                    Revisa tu bandeja de entrada y sigue la secuencia de pasos para restablecer tu contraseña.
                </p>
                <asp:Button ID="btnContinuar" runat="server" type="button" class="btn btn-primary px-4" text="continuar" OnClick="btnContinuar2_Click" />
            </div>
        </div>
    </div>

    <script>
        // Mostrar modal al enviar
        function mostrarModal() {
            var modal = new bootstrap.Modal(document.getElementById('modalVerifica'));
            modal.show();
        }
    </script>

</asp:Content>
