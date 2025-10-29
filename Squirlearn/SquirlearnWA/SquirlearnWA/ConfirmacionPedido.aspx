﻿<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPages/SquirLearn.Master" AutoEventWireup="true" CodeBehind="ConfirmacionPedido.aspx.cs" Inherits="SquirlearnWA.ConfirmacionPedido" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphContenido" runat="server">

    <div class="container text-center mt-5">
        <!-- Imagen de confirmación -->
        <div class="mt-5">
            <img src="https://cdn-icons-png.flaticon.com/512/845/845646.png"
                 alt="Confirmado"
                 style="width:120px; margin-bottom:20px; animation: pop 0.6s ease;">
            
            <h4 class="fw-bold text-success">¡Proceso realizado con éxito!</h4>
            <p class="text-muted mb-4">
                Tu pedido ha sido confirmado correctamente.<br />
                El vendedor se pondrá en contacto contigo para coordinar la entrega.
            </p>

            <!-- Botón para ir al chat con el vendedor -->
            <asp:Button ID="btnIrChat" runat="server" CssClass="btn btn-outline-success fw-semibold me-2"
                        Text="Ir al chat con el vendedor" OnClick="btnIrChat_Click" />

            <!-- Botón volver al inicio -->
            <asp:Button ID="btnVolverInicio" runat="server" CssClass="btn btn-primary fw-semibold"
                        Text="Volver al inicio" OnClick="btnVolverInicio_Click" />
        </div>
    </div>

    <style>
        @keyframes pop {
            0% { transform: scale(0.8); opacity: 0; }
            100% { transform: scale(1); opacity: 1; }
        }
    </style>

</asp:Content>